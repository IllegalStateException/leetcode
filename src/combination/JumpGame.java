package combination;

import java.util.Arrays;

public class JumpGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JumpGame jg = new JumpGame();
		int[] nums = new int[]{1,2,3};
		System.out.println(jg.jump3(nums));
	}
	
	//dp result in time limit exceed.
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
	
	//jump game ii  greedy solution
	public int jump3(int[] nums){
		int length;
		if(nums == null || (length = nums.length) <= 1)
			return 0;
		
		int canReach = nums[0];
		int nextStepCanReach = 0;
		int count = 0;
		
		for(int i = 0;i < length;i++){
			if(i + nums[i] > canReach)
				nextStepCanReach = Math.max(nextStepCanReach, i+nums[i]);
			if(canReach >= length-1){
				count++;
				return count;
			}
			if(i == canReach){
				canReach = nextStepCanReach;
				count++;
			}
		}
		return 0;
	}
	
	//jump game
	public boolean jump2(int[] nums){
		if(nums == null || nums.length <= 1)
			return true;
		
		int canReach = nums[0];
		for(int i = 0;i < nums.length-1;i++){
			
			if(canReach == i && nums[i] == 0)
				return false;
			if(i + nums[i] > canReach)
				canReach = i + nums[i];
			
			if(canReach >= nums.length-1)
				return true;
		}
		return false;
	}

}
