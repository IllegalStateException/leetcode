package combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

 * @author zwb
 *
 */
public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{3,2,4};
		System.out.println(twoSum2(nums,6));
	}
	public static int[] twoSum(int[] nums, int target) {
		if(nums == null || nums.length < 2)
			return null;
        int[] result = new int[2];
        for(int i = 0;i < nums.length - 1;i++){
        	
        	for(int j = i+1;j < nums.length;j++){
        		if(nums[i] + nums[j] == target){
        			result[0] = i;
        			result[1] = j;
        			return result;
        		}
        	}
        }
        return result;
    }
	
	public static int[] twoSum2(int[] nums,int target){
		if(nums == null || nums.length < 2)
			return null;
		Map<Integer,List<Integer>> map = new HashMap<>();
		
		int[] result = new int[2];
		List<Integer> element;
		for(int i = 0;i < nums.length;i++){
			if(!map.containsKey(nums[i])){
				element = new ArrayList<>();
			}
			else{
				element = map.get(nums[i]);
			}
			element.add(i);
			map.put(nums[i], element);
		}
		
		for(int i = 0;i < nums.length;i++){
			if((element = map.get(target - nums[i])) != null){
				if(target == 2 * nums[i] && element.size() > 1){
					result[0] = element.get(0);
					result[1] = element.get(1);
					return result;
				}
				else if (target != 2 * nums[i]) {
					result[0] = i;
					result[1] = map.get(target - nums[i]).get(0);
					return result;
				}
			}
		}
		return null;
	}
	
	public static int[] twoSum3(int[] nums, int target) {   
	     if(nums == null)
	    	 return null;

	    int len = nums.length;
	    int[] arr =  Arrays.copyOf(nums, len);

	    Arrays.sort(arr);

	    int a = 0, b = 0;

	    //find the two values
	    int start = 0;
	    int end = len-1;
	    while(start < end){
	        int sum = arr[start]+arr[end];
	        if(target == sum){
	            a = arr[start];
	            b = arr[end];
	            break;
	        }
	        if(target > sum){
	            start++;
	        }else if(target < sum){
	            end--;
	        }
	    }
	    
	    if(a + b != target)
	    	return null;

	    //find the indexs of the two nums.
	    int aa = 0;
	    int bb = 0;
	    boolean isAAssign = true;
	    boolean isBAssign = true;
	    for(int i = 0; i < len; i++){
	        if(isAAssign && nums[i] == a){
	            aa = i;
	            isAAssign = false;
	        }else if(isBAssign && nums[i] == b){
	            bb = i;
	            isBAssign = false;
	        }
	        else if(!isAAssign && !isBAssign)
	        	break;
	    }

	    return new int[]{aa, bb};
	}

}
