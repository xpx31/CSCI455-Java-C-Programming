
public class string1UpToN {
	public static void main(String args[]) {
		System.out.println(string1UpToN(10));
	}
	
	public static String string1UpToN(int n) {
		return RAppendUpTo("", 1, n);
	}
	
	private static String RAppendUpTo(String strSoFar, int i, int n) {
		if(i < n) {
			return i + " " + RAppendUpTo(strSoFar, i + 1, n);
		}
		else {
			return "" + n;
		}
	}
}
