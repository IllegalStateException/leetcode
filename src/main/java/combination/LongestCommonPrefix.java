package combination;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a function to find the longest common prefix string amongst an array of strings. 
 * @author zwb
 *
 */
public class LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = new String[]{"aa","aab","aac","aad","ac","d"};
		
		System.out.println(longestCommonPrefix(strs));
	}
	
	/**
	 * 思路,先找出数组中长度最短的字符串list,再找出这些长度最短的字符串的公共前缀str,
	 * 则整个数组的最长公共前缀一定是str的子字符串或者是str本身.
	 * @param strs
	 * @return
	 */
	public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)
        	return "";
        int minLength = strs[0].length();
        for(String str : strs){
        	if(str.length() < minLength)
        		minLength = str.length();
        }
        List<String> minLengthStrs = new ArrayList<>();
        for(String str : strs){
        	if(str.length() == minLength)
        		minLengthStrs.add(str);
        }
        String minLengthStrsCommonTemp = "";
        String minLengthStrsCommon = "";
        outer:for(int i = 0;i < minLength;i++){
        	minLengthStrsCommonTemp = minLengthStrs.get(0).substring(0, i+1);
        	for(String str : strs){
        		if(!str.startsWith(minLengthStrsCommonTemp)){
        			break outer;
        		}
        	}
        	minLengthStrsCommon = minLengthStrsCommonTemp;
        }
        if(minLengthStrsCommon.equals(""))
        	return "";
        
        String commonPre = minLengthStrsCommon;
        out:for(int i = minLengthStrsCommon.length();i > 0 ;i--){
        	commonPre = minLengthStrsCommon.substring(0,i);
        	for(String str : strs){
        		if(!str.startsWith(commonPre)){
        			continue out;
        		}
        	}
        	break;
        }
        return commonPre;
    }
}
