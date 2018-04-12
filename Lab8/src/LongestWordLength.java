import java.util.Scanner;

public class LongestWordLength{

	public static void main(String[] args) {
		String s1 = "What is the longest word";
		String s2 = "some words";
		String s3 = "one";

		System.out.println(longestWordLen(s1));
		System.out.println(longestWordLen(s2));
		System.out.println(longestWordLen(s3));
	}

	public static int longestWordLen(String words) {
		Scanner scan = new Scanner(words);
		int maxLength = 0;
		
		maxLength = countWords(scan, maxLength);
		
		return maxLength;
	}

	private static int countWords(Scanner scan, int maxLength) {
		int length = 0;
		if(scan.hasNext()) {
			length = scan.next().length();
			if(length > maxLength) {
				maxLength = length;
			}
		}
		else {
			return maxLength;
		}
		
		return countWords(scan, maxLength);
	}
}