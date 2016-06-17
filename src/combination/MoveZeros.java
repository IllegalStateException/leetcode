package combination;



public class MoveZeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MoveZeros mz = new MoveZeros();
		int[] nums = new int[]{1,2,3,0,5};
		mz.moveZeroes(nums);
		
		for(int n : nums){
			System.out.print(n);
		}
	}
	
	public void moveZeroes(int[] nums){
		int length = nums.length;
		
		for(int i = 0;i < length;){
			if(nums[i] == 0){
				for(int j = i+1; j < length;j++){
					nums[j-1] = nums[j];
				}
				nums[--length] = 0;
			}
			else
				i++;
		}
	}

}
