import java.util.Arrays;

/**
   Stores a sequence of integer data values and supports some computations
   with it.

   CS 455 Lab 4.
*/
public class NumsArry {
	private int[] nums;
	private int numSize;
	private final int DEFAULT_CAPACITY = 3;

    /**
       Create an empty sequence of nums.
     */
    public NumsArry () {
    	nums = new int[DEFAULT_CAPACITY];
    	numSize = 0;
    }

    /**
       Add a value to the end of the sequence.
     */
    public void add(int value) {
    	if ((numSize + 1) == nums.length) {
    		nums = Arrays.copyOf(nums, nums.length * 2);
    	}
    	nums[numSize] = value;
    	numSize++;
    }

    /**
       Return the minimum value in the sequence.
       If the sequence is empty, returns Integer.MAX_VALUE
     */
    public int minVal() {
    	int minValue = nums[0];
    	for (int i = 1; i < numSize; i++) {
    		if (nums[i] < minValue) {
    			minValue = nums[i];
    		}
    	}
	return minValue;
    }

    /**
       Prints out the sequence of values as a space-separated list 
       on one line surrounded by parentheses.
       Does not print a newline.
       E.g., "(3 7 4 10 2 7)", for empty sequence: "()"
    */
    public void printVals() {
    	System.out.print("(");
    	for (int i = 0; i < numSize; i++) {
    		System.out.print(nums[i]);
    		if (i < numSize - 1) {
    			System.out.print(" ");
    		}
    	}
    	System.out.print(")");
    	System.out.println();
    }

    /**
       Returns a new Nums object with all the values from this Nums
       object that are above the given threshold.  The values in the
       new object are in the same order as in this one.
       E.g.: call to myNums.valuesGT(10) where myNums = (3 7 19 4 21 19 10)
             returns      (19 21 19)
             myNums after call:  (3 7 19 4 21 19 10)
       The method does not modify the object the method is called on.
     */
    public Nums valuesGT(int threshold) {
    	Nums numsVGT = new Nums();
    	
    	for (int i = 0; i < numSize; i++) {
    		if (nums[i] > threshold) {
    			numsVGT.add(nums[i]);
    		}
    	}
    	
	return numsVGT;

    }

    
}
