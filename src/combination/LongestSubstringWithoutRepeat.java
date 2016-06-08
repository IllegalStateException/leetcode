package combination;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "asjrgapa";
		LongestSubstringWithoutRepeat lswr = new LongestSubstringWithoutRepeat();
		System.out.println(lswr.lengthOfLongestSubstring(s));
	}
	
	public int lengthOfLongestSubstring(String s) {
		if(s == null || "".equals(s))
        	return 0;
        char[] chars = s.toCharArray();
        int maxLen = 0;
        Map<Character,Integer> map = new HashMap<>();
        
        int currentLen = 0;
        int start = 0;
        
        for(int i = 0; i < chars.length;i++){
        	char c = chars[i];
        	if(map.get(c) == null){
        		currentLen++;
        		if(currentLen > maxLen)
        			maxLen = currentLen;
        	}
        	else{
        		int index = map.get(c);
        		currentLen = i - index;
        		
        		for(int j = start;j <= index;j++){
        			map.remove(chars[j]);
        		}
        		start = index+1;
        	}
        	map.put(c,i);
        }
        return maxLen;
    }

}
