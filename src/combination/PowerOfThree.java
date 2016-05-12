package combination;

/**
 * Given an integer, write a function to determine if it is a power of three. 
 * @author zwb
 *
 */
public class PowerOfThree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(isPowerOfThree(9));
	}
	public static boolean isPowerOfThree(int n) {
        
		if(n <= 0)
			return false;
		int maxPower = (int)Math.pow(3, (int)(Math.log(Integer.MAX_VALUE)/Math.log(3)));
		
		return maxPower % n == 0;
    }

}
