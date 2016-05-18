package combination;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        
        backTracking(nums,result,new ArrayList<Integer>());
        
        return result;
		
    }
	
	private void backTracking(int[] nums,List<List<Integer>> result,List<Integer> item){
		if(item.size() == nums.length){
			result.add(new ArrayList<Integer>(item));
			return;
		}
		
		for(int i = 0;i < nums.length;i++){
			if(!item.contains(nums[i])){
				item.add(nums[i]);
				backTracking(nums,result,item);
				item.remove(item.size()-1);
			}
		}
	}

}
