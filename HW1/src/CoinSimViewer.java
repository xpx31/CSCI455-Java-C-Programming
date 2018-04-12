// Name: Pengxiang Xu
// USC NetID: pengxiax
// CS 455 PA1
// Fall 2017

import java.util.Scanner;
import javax.swing.JFrame;

/**
 * class CoinSimViewer
 * 
 * Prompts for the number of trails, and creates the JFrame containing
 * the CoinSimComponent.
 *  
 * Invariant: 
 */

public class CoinSimViewer {
	public static void main(String[] args) {
		int numTrails = 0;
		final int FRAME_HEIGHT = 800;
		final int FRAME_WIDTH = 500;
		
		// Scan User Input
		Scanner scan = new Scanner(System.in);

		do {// Continue scanning user input unless integer input > 0
			System.out.print("Enter number of trails: ");
			numTrails = scan.nextInt();
			if (numTrails <= 0) {
				System.out.println("ERROR: Number entered must be greater than 0.");
			}
		}while(numTrails <= 0);
		
		// Display Window
		JFrame frame = new JFrame();
		
		frame.setSize(FRAME_HEIGHT, FRAME_WIDTH);
		frame.setTitle("CoinSim");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		CoinSimComponent coinComponent = new CoinSimComponent(numTrails);
		frame.add(coinComponent);
		
		frame.setVisible(true);
	}
}
