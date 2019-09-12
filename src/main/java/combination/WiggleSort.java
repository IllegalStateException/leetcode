package combination;

import java.util.Arrays;

public class WiggleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{5,3,1,2,6,7,8,5,5};
		wiggleSort(nums);
		
		for(int num : nums)
			System.out.print(num + " ");
		//System.out.println(Arrays.asList(nums));
	}
	
	public static void wiggleSort(int[] nums){
		if(nums == null || nums.length <= 1)
			return;
		Arrays.sort(nums);
		
		int mid = nums.length%2 == 0 ? nums.length/2 : nums.length/2+1;
		int[] left = new int[mid];
		int[] right = new int[nums.length - mid];
		
		System.arraycopy(nums, 0, left, 0, mid);
		System.arraycopy(nums, mid, right, 0, right.length);
		
		int leftCommonStart = left.length-1;
		int rightCommonEnd = 0;
		while(left[leftCommonStart] == right[rightCommonEnd]){
			leftCommonStart--;
		}
		while(leftCommonStart+1 < left.length && left[leftCommonStart+1] == right[rightCommonEnd])
			rightCommonEnd++;
		
		int index = 0;
		int n = rightCommonEnd;
		for(int k = leftCommonStart + 1;k < left.length;k++){
			nums[index++] = left[k];
			nums[index++] = right[n++];
		}
		
		int leftIndex = 0,rightIndex = 0;
		
		for(int i = index;i < nums.length;i++){
			if(i % 2 == 0){
				nums[i] = left[leftIndex++];
			}
			else{
				if(rightIndex >= rightCommonEnd && rightIndex <= rightCommonEnd+left.length-1-leftCommonStart){
					rightIndex = rightCommonEnd + left.length -1 - leftCommonStart;
				}
				nums[i] = right[rightIndex++];
			}
		}
		
	}

}
