
public class fastExpon {
	public static void main(String args[]) {
		System.out.println(fastExpon(2, 12));
	}

	public static int fastExpon(int x, int n) {
		int num = 0;
		if(n > 0) {
			num = fastExpon(x, n / 2);
			if (n % 2 == 0) {
				return (int)Math.pow((double)num, 2.0);
			}
			else {
				return x * (int)Math.pow((double)num, 2.0);
			}
		}
		else {
			return 1;
		}
	}
}
