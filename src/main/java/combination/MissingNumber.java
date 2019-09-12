package combination;

import java.util.Arrays;

/**
 *  Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one 
 *  that is missing from the array.
 *  For example,
 *  Given nums = [0, 1, 3] return 2.
 *  Note:
 *  Your algorithm should run in linear runtime complexity. Could you implement it using 
 *  only constant extra space complexity? 
 * @author zwb
 *
 */
public class MissingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{1,2,3};
		System.out.println(missingNumber2(nums));
	}
	
	/**
	 * java solution that may take 13ms
	 * @param nums
	 * @return
	 */
	public int missingNumber(int[] nums) {
		int length;
        if(nums == null || (length = nums.length) == 0)
        	return -1;
        Arrays.sort(nums);
        if(nums[length -1] != length)
        	return length;
        
        int pre = -1;
        for(int i = 0;i < length;i++){
        	if(nums[i] - pre != 1)
        		break;
        	pre = nums[i];
        }
        return pre+1;
    }
	/**
	 * java solution take only 1ms
	 * @param nums
	 * @return
	 */
	public static int missingNumber2(int[] nums){
		int length;
        if(nums == null || (length = nums.length) == 0)
        	return -1;
        int total = length * (length + 1) /2;
        
        int sum = 0;
        for(int i : nums){
        	sum += i;
        }
        return total - sum;
	}

}
