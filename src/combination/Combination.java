package combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.out.println(new Combination().myCombine(4, 2));
		Combination combination = new Combination();
		
		int[] candidates = new int[]{10,1,2,7,6,1,5};
		System.out.println(combination.combinationSum2(candidates, 8));
		/*System.out.println(new Combination().combine(4, 2));
		
		System.out.println(combination.combineSum3(3, 9));*/

	}
	
	
	public List<List<Integer>> combine(int n,int k){
		int[] nums = new int[n];
		for(int i = 1;i <= n;i++){
			nums[i-1] = i;
		}
		
		List<List<Integer>> res = new ArrayList<>();
		
		helper(nums,res,new ArrayList<Integer>(),0,k);
		
		return res;
		
	}
	
	private void helper(int[] nums,List<List<Integer>> res,ArrayList<Integer> cur,int start,int len){
		if(cur.size() == len){
			res.add(new ArrayList<Integer>(cur));
			return;
		}
		
		for(int i = start;i < nums.length - (len -cur.size()) + 1;i++){
			cur.add(nums[i]);
			helper(nums,res,cur,i+1,len);
			cur.remove(cur.size() - 1);
		}
	}
	
	public List<List<Integer>> combineSum3(int k,int n){
		int[] nums = new int[n];
		for(int i = 1;i <= n;i++){
			nums[i-1] = i;
		}
		
		List<List<Integer>> res = new ArrayList<>();
		if(k > 9 || n > (19 - k) * k/2){
			return res;
		}
		combineSumHelper(n,nums,res,new ArrayList<Integer>(),0,k);
		return res;
	}
	
	private void combineSumHelper(int total,int[] nums,List<List<Integer>> res,ArrayList<Integer> cur,int start,int len){
		if(cur.size() == len){
			if(sum(cur) == total){
				res.add(new ArrayList<Integer>(cur));
			}
			return;
		}
		for(int i = start;i < nums.length - len + cur.size() + 1;i++){
			cur.add(nums[i]);
			if((nums[i] + (len - cur.size())/2) * (len - cur.size()) +sum(cur) > total){
				cur.remove(cur.size() - 1);
				return;
			}
			combineSumHelper(total,nums,res,cur,i+1,len);
			cur.remove(cur.size()-1);
		}
	}
	
	
	public List<List<Integer>> combinationSum(int[] candidates,int target){
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(candidates);
		
		backTracking(candidates,new ArrayList<Integer>(),result,0,target);
		
		return result;
		
	}
	
	private void backTracking(int[] candidates,List<Integer> item,List<List<Integer>> result,int start,int target){
		
		if(sum(item) == target){
			if(!result.contains(item)){
				result.add(new ArrayList<Integer>(item));
			}
			return;
		}
		
		for(int i = start;i < candidates.length;i++){
			item.add(candidates[i]);
			if(sum(item) > target){
				item.remove(item.size()-1);
				return;
			}
			backTracking(candidates,item,result,i,target);
			item.remove(item.size()-1);
		}
		
	}
	
	public List<List<Integer>> combinationSum2(int[] candidates,int target){
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(candidates);
		
		backTracking2(candidates,new ArrayList<Integer>(),result,0,target);
		
		return result;
		
	}
	
	private void backTracking2(int[] candidates,List<Integer> item,List<List<Integer>> result,int start,int target){
		
		if(sum(item) == target){
			if(!result.contains(item)){
				result.add(new ArrayList<Integer>(item));
			}
			return;
		}
		
		for(int i = start;i < candidates.length;i++){
			item.add(candidates[i]);
			if(sum(item) > target){
				item.remove(item.size()-1);
				return;
			}
			backTracking2(candidates,item,result,i+1,target);
			item.remove(item.size()-1);
		}
		
	}
	
	private int sum(List<Integer> list){
		int sum = 0;
		for(Integer i : list){
			sum += i;
		}
		return sum;
	}
	
	/*public List<List<Integer>> myCombine(int n,int k){
		
	}*/
	
}
