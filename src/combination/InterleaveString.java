package leetcode;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 * 
 * @author zwb
 *
 */
public class InterleaveString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterleaveString ls = new InterleaveString();
		String s1 = "aa";
		String s2 = "ab";
		System.out.println(ls.isInterleave(s1, s2, "abaa"));
		//System.out.println(ls.isInterleave(s1, s2, "aabaccdcbb"));

	}
	
	public boolean isInterleave(String s1, String s2, String s3) {
		if(isEmpty(s1) && isEmpty(s2)){
			return isEmpty(s3) ? true : false;
		}
        if(isEmpty(s1)){
        	return s2.equals(s3);
        }
        if(isEmpty(s2)){
        	return s1.equals(s3);
        }
        if(s1.length() + s2.length() != s3.length()){
        	return false;
        }
        
        int s1Length = s1.length();
        int s2Length = s2.length();
        
        //boolean[i][j] 表示s3的前i+j位，是否可以由s1的前i位加上s2的前j位交叉得到。
        boolean[][] path = new boolean[s1Length + 1][s2Length + 1];
        path[0][0] = true; 
        
        for(int i = 1;i <= s1Length;i++){
        	if(path[i-1][0] && s3.charAt(i-1) == s1.charAt(i-1)){
        		path[i][0] = true;
        	}
        }
        
        for(int j = 1;j <= s2Length;j++){
        	if(path[0][j-1] && s3.charAt(j-1) == s2.charAt(j-1)){
        		path[0][j] = true;
        	}
        }
        
        for(int i = 1;i <= s1Length;i++){
        	for(int j = 1;j<= s2Length;j++){
        		if(path[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1)){
        			path[i][j] = true;
        		}
        		else if(path[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1)){
        			path[i][j] = true;
        		}
        	}
        }
        
        return path[s1Length][s2Length];
        
    }
	
	private boolean isEmpty(String str){
		return str == null || "".equals(str);
	}
}
 