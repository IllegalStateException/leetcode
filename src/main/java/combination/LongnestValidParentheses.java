package combination;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a string containing just the characters '(' and ')', find the length of the longest valid 
 * 
 * (well-formed) parentheses substring.
 * 
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * 
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4. 
 * @author zwb
 *
 */
public class LongnestValidParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "(()()";
		System.out.println(longestValidParentheses2(str));
	}
	
	
	
	/**
	 * 由于没有完全理解题意,做出的错误解法.可以解决()()这样的问题,但是不能解决(())这样的问题.
	 * @param s
	 * @return
	 */
	public static int longestValidParentheses(String s) {
	    if(s == null || s.length() < 2)
	    	return 0;
	    boolean isOpen = false;
	    boolean isClose = true;
	    int length = 0;
	    int maxLength = 0;
	    for(int i = 0;i < s.length();i++){
	    	if(s.charAt(i) == '(' && !isOpen && isClose){
	    		isOpen = true;
	    		isClose = false;
	    	}
	    	else if(s.charAt(i) == '(' && isOpen && !isClose){
	    		length = 0;
	    	}
	    	else if(s.charAt(i) == ')' && isOpen && !isClose){
	    		isOpen = false;
	    		isClose = true;
	    		length += 2;
	    		if(length > maxLength){
	    			maxLength = length;
	    		}
	    	}
	    	else{
	    		length = 0;
	    		isOpen = false;
	    		isClose = true;
	    	}
	    }
	    return maxLength;
	}
	
	/**
	 * O(n）solution
	 * @param s
	 * @return
	 */
	public static int longestValidParentheses2(String s) {
	    int max=0,start=0;
	    
	    Deque<Integer> stack=new ArrayDeque<>();
	    
	    int[] a = new int[s.length()];
	    char[] c = s.toCharArray();
	    for(int i = 0;i < c.length;i++){
	        if(c[i] == '(') 
	        	stack.push(i);
	        else if(!stack.isEmpty()){
	            start = stack.pop();
	            a[i] = i - start + 1;
	            if(start > 1) 
	            	a[i] += a[start-1];
	            max = Math.max(max,a[i]);
	        }
	    }
	    return max;
	}
}
