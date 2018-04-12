// Name: Pengxiang Xu
// USC NetID: pengxiax
// CS 455 PA1
// Fall 2017

/**
 * class CoinTossSimulatorTester
 * 
 * Test CoinTossSimulator class independently from its use in
 * the CoinSimViewer program
 *  
 * Invariant: 
 */

public class CoinTossSimulatorTester {
	public static void main(String[] args) {
		int numTrails;
		int twoHeadToss;
		int twoTailToss;
		int headTailToss;
		boolean isTossAddUp;
		
		/**
		// Variables for examining error
		int probTwoHead;
		int probTwoTail;
		int probHeadTail;
		int errorTwoHead;
		int errorTwoTail;
		int errorHeadTail;
		int numTrailSum = 0;
		final int EXAM_SIZE = 10000; // the size of exam on the minimum number of trails that 
							          // can achieve within 1% of each probability distribution
		final int PROB_HALF = 50; // Half probability in percent = 50%
		final int PROB_QUARTER = 25; // 1/4 probability in percent = 25%
		final int PROB_LIMIT = 1; // 1 percent limit = 1%
		*/
		
		/**
		//Variables for examining overflow
		int count = 0;
		*/
						
		CoinTossSimulator cts = new CoinTossSimulator();
		numTrails = cts.getNumTrials();
		twoHeadToss = cts.getTwoHeads();
		twoTailToss = cts.getTwoTails();
		headTailToss = cts.getHeadTails();
		
		if (numTrails == twoHeadToss + twoTailToss + headTailToss) {
			isTossAddUp = true;			
		}
		else {
			isTossAddUp = false;
		}
		
		System.out.println("After constructor: ");
		System.out.println("Number of tralis [exp: 0]: " + numTrails);
		System.out.println("Two-head tosses: " + twoHeadToss);
		System.out.println("Two-tail tosses: " + twoTailToss);
		System.out.println("One-head one-tail tosses: " + headTailToss);
		System.out.println("Tosses add up correctly? " + isTossAddUp);
		System.out.println();
		
		// After run (1)
		cts.run(1);
		numTrails = cts.getNumTrials();
		twoHeadToss = cts.getTwoHeads();
		twoTailToss = cts.getTwoTails();
		headTailToss = cts.getHeadTails();
		
		if (numTrails == twoHeadToss + twoTailToss + headTailToss) {
			isTossAddUp = true;			
		}
		else {
			isTossAddUp = false;
		}
		
		System.out.println("After run(1): ");
		System.out.println("Number of tralis [exp: 1]: " + numTrails);
		System.out.println("Two-head tosses: " + twoHeadToss);
		System.out.println("Two-tail tosses: " + twoTailToss);
		System.out.println("One-head one-tail tosses: " + headTailToss);
		System.out.println("Tosses add up correctly? " + isTossAddUp);
		System.out.println();
		
		// After run (10) without reset
		cts.run(10);
		numTrails = cts.getNumTrials();
		twoHeadToss = cts.getTwoHeads();
		twoTailToss = cts.getTwoTails();
		headTailToss = cts.getHeadTails();
		
		if (numTrails == twoHeadToss + twoTailToss + headTailToss) {
			isTossAddUp = true;			
		}
		else {
			isTossAddUp = false;
		}
		
		System.out.println("After run(10): ");
		System.out.println("Number of tralis [exp: 11]: " + numTrails);
		System.out.println("Two-head tosses: " + twoHeadToss);
		System.out.println("Two-tail tosses: " + twoTailToss);
		System.out.println("One-head one-tail tosses: " + headTailToss);
		System.out.println("Tosses add up correctly? " + isTossAddUp);
		System.out.println();
		
		// After run (100) without reset
		cts.run(100);
		numTrails = cts.getNumTrials();
		twoHeadToss = cts.getTwoHeads();
		twoTailToss = cts.getTwoTails();
		headTailToss = cts.getHeadTails();
		
		if (numTrails == twoHeadToss + twoTailToss + headTailToss) {
			isTossAddUp = true;			
		}
		else {
			isTossAddUp = false;
		}
		
		System.out.println("After run(100): ");
		System.out.println("Number of tralis [exp: 111]: " + numTrails);
		System.out.println("Two-head tosses: " + twoHeadToss);
		System.out.println("Two-tail tosses: " + twoTailToss);
		System.out.println("One-head one-tail tosses: " + headTailToss);
		System.out.println("Tosses add up correctly? " + isTossAddUp);
		System.out.println();
		
		// After run (1000) without reset
		cts.run(1000);
		numTrails = cts.getNumTrials();
		twoHeadToss = cts.getTwoHeads();
		twoTailToss = cts.getTwoTails();
		headTailToss = cts.getHeadTails();
		
		if (numTrails == twoHeadToss + twoTailToss + headTailToss) {
			isTossAddUp = true;			
		}
		else {
			isTossAddUp = false;
		}
		
		System.out.println("After run(1000): ");
		System.out.println("Number of tralis [exp: 1111]: " + numTrails);
		System.out.println("Two-head tosses: " + twoHeadToss);
		System.out.println("Two-tail tosses: " + twoTailToss);
		System.out.println("One-head one-tail tosses: " + headTailToss);
		System.out.println("Tosses add up correctly? " + isTossAddUp);
		System.out.println();
		
		// After reset
		cts.reset();
		numTrails = cts.getNumTrials();
		twoHeadToss = cts.getTwoHeads();
		twoTailToss = cts.getTwoTails();
		headTailToss = cts.getHeadTails();
		
		if (numTrails == twoHeadToss + twoTailToss + headTailToss) {
			isTossAddUp = true;			
		}
		else {
			isTossAddUp = false;
		}
		
		System.out.println("After reset: ");
		System.out.println("Number of tralis [exp: 0]: " + numTrails);
		System.out.println("Two-head tosses: " + twoHeadToss);
		System.out.println("Two-tail tosses: " + twoTailToss);
		System.out.println("One-head one-tail tosses: " + headTailToss);
		System.out.println("Tosses add up correctly? " + isTossAddUp);
		System.out.println();
		
		// After run (1000) after reset
		cts.run(1000);
		numTrails = cts.getNumTrials();
		twoHeadToss = cts.getTwoHeads();
		twoTailToss = cts.getTwoTails();
		headTailToss = cts.getHeadTails();
		
		if (numTrails == twoHeadToss + twoTailToss + headTailToss) {
			isTossAddUp = true;			
		}
		else {
			isTossAddUp = false;
		}
		
		System.out.println("After run(1000): ");
		System.out.println("Number of tralis [exp: 1000]: " + numTrails);
		System.out.println("Two-head tosses: " + twoHeadToss);
		System.out.println("Two-tail tosses: " + twoTailToss);
		System.out.println("One-head one-tail tosses: " + headTailToss);
		System.out.println("Tosses add up correctly? " + isTossAddUp);
		System.out.println();
		
		// After run (111) after reset and run(1000)
		cts.run(111);
		numTrails = cts.getNumTrials();
		twoHeadToss = cts.getTwoHeads();
		twoTailToss = cts.getTwoTails();
		headTailToss = cts.getHeadTails();
		
		if (numTrails == twoHeadToss + twoTailToss + headTailToss) {
			isTossAddUp = true;			
		}
		else {
			isTossAddUp = false;
		}
		
		System.out.println("After run(111): ");
		System.out.println("Number of tralis [exp: 1111]: " + numTrails);
		System.out.println("Two-head tosses: " + twoHeadToss);
		System.out.println("Two-tail tosses: " + twoTailToss);
		System.out.println("One-head one-tail tosses: " + headTailToss);
		System.out.println("Tosses add up correctly? " + isTossAddUp);
		System.out.println();
		
		/**
		// Examining Error
		// Reset and run to get within 1% probability
		cts.reset();
		
		for (int i = 0; i < EXAM_SIZE; i++) {
			int trails = 1;
			boolean isErrorSmall = false;
			while (isErrorSmall == false) {
				cts.run(trails);
				numTrails = cts.getNumTrials();
				twoHeadToss = cts.getTwoHeads();
				twoTailToss = cts.getTwoTails();
				headTailToss = cts.getHeadTails();
				
				probTwoHead = (int)(((double)twoHeadToss / (double)numTrails) * 100);
				probTwoTail = (int)(((double)twoTailToss / (double)numTrails) * 100);
				probHeadTail = (int)(((double)headTailToss / (double)numTrails) * 100);
				
				errorTwoHead = Math.abs(probTwoHead - PROB_QUARTER);
				errorTwoTail = Math.abs(probTwoTail - PROB_QUARTER);
				errorHeadTail = Math.abs(probHeadTail - PROB_HALF);
							
				if (errorTwoHead <= PROB_LIMIT && 
					errorTwoTail <= PROB_LIMIT && 
					errorHeadTail <= PROB_LIMIT) {
					isErrorSmall = true;
				}
				trails += 1;
				
				System.out.println("Trails: " + (trails - 1));
				System.out.println("Two Head: " + probTwoHead + " Head and Tail: " + probHeadTail + " Two Tail: " + probTwoTail);
			}		
			numTrailSum += trails - 1;
			cts.reset();
		}
		System.out.println((int)(numTrailSum / EXAM_SIZE));
		*/
		
		/**
		//Examining overflow
		cts.reset();
		while(true) {
			cts.run(count);
			numTrails = cts.getNumTrials();
			System.out.println(numTrails);
			count += 100000000;
		}
		*/
	}
}
