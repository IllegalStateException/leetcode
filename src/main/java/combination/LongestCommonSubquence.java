package combination;

public class LongestCommonSubquence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = new int[]{1,6,2,6,3,8,5};
		int[] nums2 = new int[]{4,5,6,7,1,2,3,5};
		
		LongestCommonSubquence lcs = new LongestCommonSubquence();
		System.out.println(lcs.lcsSuccessive(nums1, nums2));
		
	}
	
	public int lcs(int[] nums1,int[] nums2){
		
		int xLen = nums1.length;
		int yLen = nums2.length;
		
		int[] pre = new int[xLen];
		int maxLen = 0;
		
		for(int i = 0;i < yLen;i++){
			int key = nums2[i];
			int[] current = new int[xLen];
			for(int j = 0;j < xLen;j++){
				if(j == 0)
					current[j] = 1;
				else{
					if(nums1[j] == key){
						current[j] = pre[j-1] + 1;
						if(current[j] > maxLen)
							maxLen = current[j];
						    //这里可以记录最长公共子串出现的位置,配合maxLen可以找到一个最长子串.
					}
				}
			}
			pre = current;
			current = null;
		}
		return maxLen;
	}
	private static final String LEFT_UP = "left_up";
	private static final String LEFT = "left";
	private static final String UP = "up";
	
	public int lcsSuccessive(int[] nums1,int[] nums2){
		int xLen = nums1.length;
		int yLen = nums2.length;
		
		int[][] dp = new int[xLen+1][yLen+1];
		//回溯法输出其中一种最长子序列
		String[][] backtracking= new String[xLen+1][yLen+1];
		
		for(int i = 1;i <= xLen;i++){
			int key = nums1[i-1];
			
			for(int j = 1;j <= yLen;j++){
				if(nums2[j-1] == key){
					dp[i][j] = dp[i-1][j-1] + 1;
					backtracking[i][j] = LEFT_UP;
				}
				else{
					if(dp[i][j-1] >= dp[i-1][j]){
						dp[i][j] = dp[i][j-1];
						backtracking[i][j] = UP;
					}
					else{
						dp[i][j] = dp[i-1][j];
						backtracking[i][j] = LEFT;
					}
				}
			}	
		}
		System.out.println(backtrack(xLen,yLen,backtracking,new StringBuilder(),nums1));
		return dp[xLen][yLen];
	}
	
	private String backtrack(int i,int j,String[][] backtracking,StringBuilder sb,int[] nums1){
		if(i == 0 || j == 0)
			return sb.reverse().toString();
		if(LEFT_UP.equals(backtracking[i][j])){
			sb.append(nums1[i-1]);
			return backtrack(i-1,j-1,backtracking,sb,nums1);
		}
		else if(LEFT.equals(backtracking[i][j]))
			return backtrack(i-1,j,backtracking,sb,nums1);
		else
			return backtrack(i,j-1,backtracking,sb,nums1);
		
	}

}
