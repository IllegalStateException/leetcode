package combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{-5,1,-3,-1,-4,-2,4,-1,-1,1,1};
		ThreeSum ts = new ThreeSum();
		
		System.out.println(ts.threeSum(nums));
	}
	
	public List<List<Integer>> threeSum(int[] nums){
		Arrays.sort(nums);
		int length;
		List<List<Integer>> result = new ArrayList<>();
		if((length=nums.length) == 0 || nums[0] > 0 || nums[length-1] < 0)
			return result;
		
		int lastNegative = -1,fisrtPositive = -1;
		
		for(int i = 0; i < length;i++){
			if(nums[i] < 0 && nums[i+1] >= 0)
				lastNegative = i;
			else if(nums[i] > 0 && nums[i-1] <= 0){
				fisrtPositive = i;
				break;
			}
		}
		
		int timeOfZero = 0;
		if(lastNegative == -1 && fisrtPositive == -1)
			timeOfZero = length;
		else
			timeOfZero = lastNegative < 0 ? fisrtPositive :fisrtPositive - lastNegative-1;
		if(timeOfZero >= 3)
			result.add(Arrays.asList(new Integer[]{0,0,0}));
		if(lastNegative >= 0 && fisrtPositive >= 0){
			for(int j = 0;j <= lastNegative;){
				int tmp = nums[j];
				if(timeOfZero > 0){
					if(Arrays.binarySearch(nums,fisrtPositive,length, -nums[j]) >= 0){
						result.add(Arrays.asList(new Integer[]{nums[j],0,-nums[j]}));
					}
				}
				
				for(int k = j+1;k <= lastNegative;){
					int temp = nums[k];
					if(Arrays.binarySearch(nums,fisrtPositive,length, -nums[j]-nums[k]) >= 0){
						result.add(Arrays.asList(new Integer[]{nums[j],nums[k],-nums[j]-nums[k]}));
					}
					while(++k <= lastNegative && nums[k] == temp){
						//k++;
					}
				}
				while(nums[++j] == tmp){}
			}
			
			for(int j = fisrtPositive;j < length-1;){
				int tmp = nums[j];
				
				for(int k = j+1;k < length;){
					int temp = nums[k];
					if(Arrays.binarySearch(nums,0,lastNegative+1, -nums[j]-nums[k]) >= 0){
						result.add(Arrays.asList(new Integer[]{-nums[j]-nums[k],nums[j],nums[k]}));
					}
					while(++k < length && nums[k] == temp){
						//k++;
					}
				}
				while(++j < length-1 && nums[j] == tmp){}
			}
		}
		return result;
    }

}
