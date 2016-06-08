package combination;

public class MaxSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{-2,-1,-3,4,-1,2,1,-5,4};
		MaxSubArray msa = new MaxSubArray();
		System.out.println(msa.fasterMaxSubArray(nums));
	}
	
	public int maxSubArray(int[] nums) {
		if(nums == null || nums.length == 0)
			return 0;
		
		return helper(nums,0,nums.length-1);
    }
	
	private int helper(int[] nums,int start,int end){
		if(start == end)
			return nums[start];
		int mid = start + (end - start)/2;
		int leftSum = helper(nums,start,mid);
		int rightSum = helper(nums,mid+1,end);
		
		int maxLeftSum = Integer.MIN_VALUE;
		int sum = 0;
		for(int i = mid;i >= start;i--){
			sum += nums[i];
			if(sum > maxLeftSum)
				maxLeftSum = sum;
		}
		
		int maxRightSum = Integer.MIN_VALUE;
		sum = 0;
		for(int i = mid+1;i <= end;i++){
			sum += nums[i];
			if(sum > maxRightSum)
				maxRightSum = sum;
		}
		
		int crossSum = maxLeftSum + maxRightSum;
		
		return Math.max(crossSum, Math.max(leftSum, rightSum));
		
	}
	
	public int fasterMaxSubArray(int[] nums){
		if(nums == null || nums.length == 0)
			return 0;
		
		int max = nums[0];
		int sum = 0;
		
		for(int i : nums){
			sum += i;
			if(sum > max)
				max = sum;
			if(sum < 0)
				sum = 0;
		}
		return max;
	}

}
