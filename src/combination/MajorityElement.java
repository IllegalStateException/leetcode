package combination;

import java.util.Arrays;

public class MajorityElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{1,1,1,2,2,1};
		MajorityElement me = new MajorityElement();
		System.out.println(me.majorityElement(nums));
	}
	
	public int majorityElement(int[] nums){
        
		Arrays.sort(nums);
		return nums[nums.length/2];
		//the following may be replaced by the above statement.
		/*int time = 0;
		int lastNum = nums[0];
		int majority = nums.length / 2;
		for(int num : nums){
			if(num == lastNum){
				if(++time > majority)
					return num;
			}
			else{
				lastNum = num;
				time = 1;
			}
		}
		
		return 0;*/
    }
	
	public int majorityElement2(int[] nums){
		int count = 1;
		int majority = nums[0];
		
		for(int i = 1;i < nums.length;i++){
			if(nums[i] == majority)
				count++;
			else
				count--;
			if(count == 0){
				majority = nums[i];
				count = 1;
			}
		}
		return majority;
	}

}
