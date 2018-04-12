// Name: Pengxiang Xu
// USC NetID: pengxiax
// CSCI455 PA2
// Fall 2017

import java.util.ArrayList;
import java.util.Scanner;

/**
   This simulator simulates Bulgarian Solitarire game with either
   given inputs or randomly generated inputs that has 45 cards in
   total. The board will eventually be configured to 9 consecutive 
   positive integers starting from 1. The simulator will show each 
   configuration until the final state is reached.
 */

public class BulgarianSolitaireSimulator {

	public static void main(String[] args) {

		boolean singleStep = false;
		boolean userConfig = false;

		for (int i = 0; i < args.length; i++) {
			if (args[i].equals("-u")) {
				userConfig = true;
			}
			else if (args[i].equals("-s")) {
				singleStep = true;
			}
		}

		// <add code here>
		SolitaireBoard board = constructBoard(userConfig);
		playBoard(singleStep, board);
	}


	// <add private static methods here>
	/**
	 * construct a solitaire board according to user configuration
	 *  
	 * @param userConfig determine if userConfig is on or off
	 * @return return a solitaire board
	 */
	private static SolitaireBoard constructBoard(boolean userConfig) {
		SolitaireBoard board;
		
		if(userConfig == true) {		// userConfig is on
			board = userConfigOn();
		}
		else {							// userConfig is off
			board = new SolitaireBoard();
		}
		
		return board;
	}

	/**
	 * When userConfig is on, prints the input statements and construct a solitaire board
	 * If there is an error when constructing a board, prints error statement
	 * 
	 * @return user defined solitaire board
	 */
	private static SolitaireBoard userConfigOn() {
		String inputStatement = "Please enter a space-separated list of "
				+ "positive integers followed by newline: ";
		String errorStatement = "ERROR: Each pile must have at least "
				+ "one card and the total number of cards must be 45";
		
		System.out.println("Number of total cards is 45");
		System.out.println("You will be entering the initial "
				+ "configuration of the cards (i.e., how many in each pile).");

		return validateUserBoard(inputStatement, errorStatement);
	}
	
	/**
	 * takes input from user to construct a solitaire board and check its validation
	 * 
	 * @param inputStatement prints the input statement
	 * @param errorStatement when there is an error in prints an error statement
	 * @return a valid user defined solitaire board
	 */
	private static SolitaireBoard validateUserBoard(String inputStatement, String errorStatement) {
		Scanner scan = new Scanner(System.in);
		SolitaireBoard board = new SolitaireBoard();
		boolean isInputValid = false;
		
		while(isInputValid == false) {
			try {
				ArrayList<Integer> piles = new ArrayList<Integer>();
				
				System.out.println(inputStatement);
				String[] line = scan.nextLine().split(" ");
				
				for(int i = 0; i < line.length; i++) {
					piles.add(Integer.parseInt(line[i]));
				}
				
				board = new SolitaireBoard(piles);
				isInputValid = true;
				scan.reset();
			}
			catch (AssertionError Error){
				notValidInput(isInputValid, errorStatement, scan);
			}
			catch (NumberFormatException Exception) {
				notValidInput(isInputValid, errorStatement, scan);
			}
		}
		return board;
	}

	/**
	 * play the rounds of a given solitaire board with user define to pause each round
	 * through enabling singleStep
	 * 
	 * @param singleStep if user enables singleStep board pauses each round until return is hit
	 * @param board input a valid solitaire board
	 */
	private static void playBoard(boolean singleStep, SolitaireBoard board) {
		Scanner scan = new Scanner(System.in);
		String readReturn = "DEFAULT";

		System.out.println(board.configString()); // Initial configuration

		do{
			board.playRound();
			System.out.println(board.configString());

			if(singleStep == true) { // singleStep is on
				System.out.print("<Type return to continue>");
				while(readReturn.isEmpty() == false) {
					readReturn = scan.nextLine();
				}
				scan.reset();
				readReturn = "DEFAULT";
			}
		}while(board.isDone() == false);
		System.out.println("Done!");
	}
	
	/**
	 * If an error or exception is catched
	 * set isInputValid to false
	 * print error statement
	 * and reset scanner
	 * 
	 * @param isInputValid set to false if input is not valid
	 * @param errorStatement prints the error statement if input is not valid
	 * @param scan resets the scanner for next scan
	 * 
	 * @return 
	 */
	private static void notValidInput(boolean isInputValid, String errorStatement, Scanner scan) {
		isInputValid = false;
		System.out.println(errorStatement);
		scan.reset();
	}
}