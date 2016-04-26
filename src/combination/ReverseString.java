package combination;

/**
 * Write a function that takes a string as input and returns the string reversed.
 * Example:
 * Given s = "hello", return "olleh". 
 * @author zwb
 *
 */
public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseString("hello everyone!"));
	}
	
	public static String reverseString(String s) {
		if(s == null)
			return null;
		StringBuilder sb = new StringBuilder();
		
		for(int i = s.length() - 1;i >= 0;i--){
			sb.append(s.charAt(i));
		}
		return sb.toString();
	}

}
