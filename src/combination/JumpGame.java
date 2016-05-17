package combination;

import java.util.Arrays;

public class JumpGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JumpGame jg = new JumpGame();
		int[] nums = new int[]{4,3,1,1,4};
		System.out.println(jg.jump(nums));
	}
	
	public int jump(int[] nums) {
		int size = nums.length;
        int[] dp = new int[size];
        
        Arrays.fill(dp, -1);
        
        dp[0] = 0;
        
		for(int i = 0;i < size;i++){
			
			int step = nums[i];
			
			for(int j = 1;j <= step;j++){
				if(i + j >= size)
					break;
				if(dp[j+i] == -1){
					dp[j+i] = dp[i] + 1;
				}
				else{
					dp[j+i] = Math.min(dp[j+i], dp[i] + 1);
				}
			}
		}
		return dp[size -1];
    }

}
