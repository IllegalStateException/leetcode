package combination;

/**
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 * 
 * Formally the function should:
 * 
 * Return true if there exists i, j, k 
 * 
 * such that arr[i] < arr[j] < arr[k] given 0 �� i < j < k �� n-1 else return false.
 * 
 * Your algorithm should run in O(n) time complexity and O(1) space complexity.
 * @author Administrator
 *
 */
public class IncreasingTripletSub {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{1,2,1,2,1,2,1,2};
		System.out.println(increasingTriplet(nums));
	}
	
	public static boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length < 3)
        	return false;
        int min = nums[0];
        int midum = 0;
        int total = 1;
        boolean hasSmaller = false;
        int smaller = 0;
        
        for(int i = 1;i < nums.length;i++){
        	if(total == 1){
        		if(nums[i] <= min){
        			min = nums[i];
        		}
        		else{
        			total++;
        			midum = nums[i];
        		}
        	}
        	else{
        		if(nums[i] > midum)
        			return true;
        		else if(nums[i] < min){
        			if(!hasSmaller){
        				hasSmaller = true;
        				smaller = nums[i];
        			}
        			else{
        				if(nums[i] <= smaller){ 
        					smaller = nums[i];
        				}
        				else{
        					min = smaller;
            				midum = nums[i];
            				hasSmaller = false;
        				}
        			}
        		}
        		else{
        			if(hasSmaller){
        				min = smaller;
        				midum = nums[i];
        				hasSmaller = false;
        			}
        			else{
        				if(nums[i] > min)
        					midum = nums[i];
        			}
        		}
        	}
        }
        return false;
    }
}
