import java.util.ArrayList;
import java.util.Scanner;

public class ReadTester {
	public static void main(String[] args) {

		while(true) {
			Scanner scan = new Scanner(System.in);
			ArrayList<Integer> read = new ArrayList<Integer>();
			System.out.print("Enter a space separated list of numbers: ");
			while(scan.hasNextInt()) {
				read.add(scan.nextInt());
			}
			System.out.println("The numbers were: " + read.toString());
		}
	}
}
