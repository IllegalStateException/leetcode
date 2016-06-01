package combination;

import java.util.Arrays;

public class LongestIncreaseingSubquence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestIncreaseingSubquence li = new LongestIncreaseingSubquence();
		//int[] nums = new int[]{1,3,6,7,9,4,10,5,6};
		int[] nums2 = new int[]{10,9,2,5,3,7,101,18};
		System.out.println(li.lengthOfLISInBI(nums2));
	}
	
	public int lengthOfLIS(int[] nums) {
		int n = nums.length;
        if(n == 0)
            return 0;
		
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		
		int max = nums[0];
		for(int i = 1;i < n;i++){
			if(nums[i] > max){
				dp[i] = dp[i-1] + 1;
				max = nums[i];
			}
			else{
				int temp = 1;
				int pre = nums[i];
				for(int j = i-1;j >= 0;j--){
					if(nums[j] < pre){
						temp++;
						pre = nums[j];
					}
				}
				if(temp >= dp[i-1]){
					dp[i] = temp;
					max = nums[i];
				}
				else
					dp[i] = dp[i-1];
			}
		}
		return dp[n-1];
    }
	public int lengthOfLISInDP(int[] nums){
		int n;
		if(nums == null || (n = nums.length) == 0)
			return 0;
		int[] dp = new int[n];
		dp[0] = 1;
		int max = dp[0];
		for(int i = 1;i < n;i++){
			dp[i] = 1;
			for(int j = i-1;j >= 0;j--){
				if(nums[j] < nums[i] && dp[i] < dp[j] + 1){
					dp[i] = dp[j] + 1;
					if(dp[i] > max)
						max = dp[i];
				}
			}
		}
		return max;
	}
	
	public int lengthOfLISInBI(int[] nums){
		int n;
		if(nums == null || (n = nums.length) == 0)
			return 0;
		int length = 0;
		int[] dp = new int[n];
		for(int num : nums){
			int index = Arrays.binarySearch(dp, 0,length,num);
			if(index < 0)
				index = -index - 1; //java类库的二分查找返回的是key的index（找到的情况）,-(insertion point + 1)insertion point即第一个比key大的元素的位置
			if(index == length)
				length++;
			dp[index] = num;
		}
		return length;
	}
	
	/*public int lengthOfLISInLCS(int[] nums){
		int n;
		if(nums == null || (n = nums.length) == 0)
			return 0;
		
	}*/

}
