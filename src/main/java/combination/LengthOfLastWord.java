package combination;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
 * return the length of last word in the string.If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * For example, 
 * Given s = "Hello World",
 * return 5.
 * 
 * @author zwb
 *
 */
public class LengthOfLastWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLastWord(" "));
	}
	
	public static int lengthOfLastWord(String s) {
		if(s == null || "".equals(s))
			return 0;
		
        int lastIndexOfSpace = s.lastIndexOf(" ");
        int length = s.length();
        if(lastIndexOfSpace < length - 1){
        	 return length - lastIndexOfSpace -1;
        }
        else{
        	int i;
        	for(i = lastIndexOfSpace - 1;i >= 0;i--){
        		if(s.charAt(i) != ' '){
        			break;
        		}
        	}
        	/*if(i < 0){
        		return lastIndexOfSpace;
        	}*/
        	//s = s.substring(0,i);
        	int j;
        	for(j = i;j>=0;j--){
        		if(s.charAt(j) == ' '){
        			break;
        		}
        	}
        	return i - j;
        }
       
    }

}
