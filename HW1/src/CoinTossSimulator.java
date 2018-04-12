// Name: Pengxiang Xu
// USC NetID: pengxiax
// CS 455 PA1
// Fall 2017

import java.util.Random;

/**
 * class CoinTossSimulator
 * 
 * Simulates trials of tossing two coins and allows the user to access the
 * cumulative results.
 * 
 * NOTE: we have provided the public interface for this class.  Do not change
 * the public interface.  You can add private instance variables, constants, 
 * and private methods to the class.  You will also be completing the 
 * implementation of the methods given. 
 * 
 * Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
 * 
 */
public class CoinTossSimulator {
   private int numTrailsCount;
   private int twoHeadToss;
   private int twoTailToss;
   private int headTailToss;
   private boolean isReset;
   private int firstToss;
   private int secondToss;
   
   private Random generator = new Random();

   /**
      Creates a coin toss simulator with no trials done yet.
   */
   public CoinTossSimulator() {
	   numTrailsCount = 0;
	   twoHeadToss = 0;
	   twoTailToss = 0;
	   headTailToss = 0;
	   isReset = false;
   }


   /**
      Runs the simulation for numTrials more trials. Multiple calls to this method
      without a reset() between them *add* these trials to the current simulation.
      
      @param numTrials  number of trials to for simulation; must be >= 1
    */
   public void run(int numTrials) {
	   if (isReset == false) {
		   for (int i = 0; i < numTrials; i++) {
			   firstToss = 1 + generator.nextInt(2); // 1 = Head; 2 = Tail
			   secondToss = 1 + generator.nextInt(2); // 1 = Head; 2 = Tail
			   
			   if (firstToss != secondToss) {
				   headTailToss++;
			   }
			   else if (firstToss == 1 && secondToss == 1) {
				   twoHeadToss++;
			   }
			   else {
				   twoTailToss++;
			   }
			   numTrailsCount++;
		   }
	   }
	   else {
		   isReset = false; // Set isReset back to default value, false
	   }
   }


   /**
      Get number of trials performed since last reset.
   */
   public int getNumTrials() {
	   numTrailsCount = getTwoHeads() + getTwoTails() + getHeadTails();
       return numTrailsCount;
   }


   /**
      Get number of trials that came up two heads since last reset.
   */
   public int getTwoHeads() {
       return twoHeadToss;
   }


   /**
     Get number of trials that came up two tails since last reset.
   */  
   public int getTwoTails() {
       return twoTailToss;
   }


   /**
     Get number of trials that came up one head and one tail since last reset.
   */
   public int getHeadTails() {
       return headTailToss;
   }


   /**
      Resets the simulation, so that subsequent runs start from 0 trials done.
    */
   public void reset() {
	   twoHeadToss = 0;
	   twoTailToss = 0;
	   headTailToss = 0;
	   numTrailsCount = 0;
	   isReset = true; // Set reset flag to true
	   this.run(0); // set reset flag back to default value (false
	                // in order to prepare for the next run call 
   }

}
