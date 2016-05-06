package combination;

public class PowerOfFour {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPowerOfFour(16));
	}
	public static boolean isPowerOfFour(int num) {
        
		return Integer.bitCount(num) == 1 && ((num & 0xAAAAAAAA) == 0);
    }
}
