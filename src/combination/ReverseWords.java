package combination;

/**
 * Given an input string, reverse the string word by word.
 * 
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * @author Administrator
 *
 */
public class ReverseWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseWords("    1   2"));
	}
	
	public static String reverseWords(String s) {
		if(s == null)
			return null;
		//ȥ����β�ո� remove spaces in the start or end.
		//if there are spaces in the mid of the string,then the element in the array
		//may be ""
		//there is also another solution which use the function replaceAll(" +"," ")
		//to replace the continuous spaces in the mid of the string to be only one.
		//but this solution is time-consuming.
        String[] strs = s.trim().split(" ");
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = strs.length-1;i >= 0;i--){
        	//if the element is "" then continue.
        	if(strs[i].equals(""))
        		continue;
        	sb.append(strs[i]);
        	if(i != 0)
        		sb.append(" ");
        }
        return sb.toString();
    }
}
