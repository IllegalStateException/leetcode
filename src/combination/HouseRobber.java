package combination;

/**
 * You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, the only constraint stopping you from 
 * robbing each of them is that adjacent houses have security system connected and it will 
 * automatically contact the police if two adjacent houses were broken into on the same 
 * night.
 * 
 * Given a list of non-negative integers representing the amount of money of each house, 
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * @author zwb
 *
 */
public class HouseRobber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = new int[]{2,1,1,2};
		System.out.println(rob2(nums));

	}
	
	public static int rob(int[] nums){
		if(nums == null || nums.length == 0)
			return 0;
		int[] mount = new int[nums.length + 1];
		mount[0] = 0;
		mount[1] = nums[0];
		
		for(int i = 2;i < mount.length;i++){
			mount[i] = Math.max(mount[i-1], nums[i-1] + mount[i-2]);
		}
		
		return mount[nums.length];
	}
	
	//if the houses are arranged in a circle.
	public static int rob2(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}
		int start = robStartOrEnd(nums, 0);
		int end = robStartOrEnd(nums, 1);
		return start > end ? start : end;
	}

	public static int robStartOrEnd(int[] nums, int start) {
		int n = nums.length;
		if (start == 0) {
			n = nums.length - 1;
		}
		int[] dp = new int[n];
		dp[start] = nums[start];
		dp[start + 1] = Math.max(nums[start], nums[start + 1]);
		for (int i = start + 2; i < n; i++) {
			dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
		}
		return dp[n - 1];
	}
}
