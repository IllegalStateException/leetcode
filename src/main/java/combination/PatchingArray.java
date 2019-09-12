package combination;

public class PatchingArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{1,2};
		System.out.println(minPatches(nums,20));
	}
	
	
	public static int minPatches(int[] nums, int n) {
		
		int index = 0;
	    int addedCount = 0;
	    long canReachTo = 0;
	    while( canReachTo < n){
	        if( nums.length > index){
	            int nextExisting = nums[index];
	            if(nextExisting == canReachTo + 1){
	                canReachTo = (canReachTo << 1) + 1;
	                index++;
	            } else if(nextExisting > canReachTo + 1){
	                addedCount++;
	                canReachTo = (canReachTo << 1) + 1;
	            } else {
	                canReachTo = nextExisting + canReachTo;
	                index++;
	            }
	        } 
	        else {
	            addedCount++;
	            canReachTo = (canReachTo << 1) + 1;
	        }
	    }
	    return addedCount;
    }

}
