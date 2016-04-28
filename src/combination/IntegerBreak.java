package combination;

/**
 * Given a positive integer n, break it into the sum of at least two positive integers 
 * and maximize the product of those integers. Return the maximum product you can get.
 * 
 * For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
 * @author Administrator
 *
 */
public class IntegerBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(integerBreak(7));
	}
	public static int integerBreak(int n) {
	   
		if(n == 2 || n == 3)
			return n - 1;
		
		int timesOf3 = n / 3;
		int tail = n - 3 * timesOf3;
		if(tail == 0)
			return (int)Math.pow(3, timesOf3);
		else if(tail == 1)
			return (int)Math.pow(3, timesOf3 -1) * 4;
		else
			return (int)Math.pow(3, timesOf3) * 2;
	}
}
