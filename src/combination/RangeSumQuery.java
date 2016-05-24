package combination;

public class RangeSumQuery {

	private long[] sums;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{-2,0,3,-5,2,-1};
		
		RangeSumQuery rsq = new RangeSumQuery(nums);
		
		System.out.println(rsq.sumRange(0, 1));
		System.out.println(rsq.sumRange(2, 5));
		System.out.println(rsq.sumRange(0, 5));
	}
	
	
	public RangeSumQuery(int[] nums) {
		int length = nums.length;
		sums = new long[length+1];
		sums[0] = 0;
		
		for(int i = 0;i < length;i++){
			sums[i+1] = sums[i] + nums[i];
		}
		
    }

    public int sumRange(int i, int j) {
        
    	return (int)(sums[j+1] - sums[i < 0 ? 0 : i]);
    	
    }

}
