package combination;

/**
 * 306
 * Additive number is a string whose digits can form additive sequence.
 * 
 * A valid additive sequence should contain at least three numbers. Except for the first 
 * two numbers, each subsequent number in the sequence must be the sum of the preceding two.
 * For example:
 * 
 * "112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
 * 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * "199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
 * 1 + 99 = 100, 99 + 100 = 199
 * 
 * Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
 * Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.
 * Follow up:
 * How would you handle overflow for very large input integers? 
 * @author zwb
 *
 */
public class AdditiveNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String temp = "211739";
		System.out.println(isAdditiveNumber(temp));
	}
	
	public static boolean isAdditiveNumber(String num){
		
		if(num == null || num.length() <= 2)
			return false;
		for(int i = 0;i < num.length()/2;i++){
			long pre = Long.parseLong(num.substring(0,i+1));
			if(num.charAt(i+1) == '0'){
				if(helper(pre,0,0,num,""+pre+0))
					return true;
				else{
					continue;
				}
			}
			for(int j = i+1;j < num.length() - Math.max(i, j-i);j++){
				long next = Long.parseLong(num.substring(i+1,j+1));
				if(helper(pre,next,0,num,""+pre+next))
					return true;
				else{
					continue;
				}
			}
		}
		return false;
	}
	
	private static boolean helper(long pre,long next,int start,String num,String temp){
		if(start == num.length())
			return true;
		String total = pre + next +"";
		
		if(temp.length() + total.length() > num.length())
			return false;
		temp += total;
		if(temp.equals(num.substring(0,temp.length())))
			return helper(next,pre+next,temp.length(),num,temp);
		return false;
	}
}
