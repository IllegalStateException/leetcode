package combination;

import prepared.TreeNode;

/**
 * You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, the only constraint stopping you from 
 * robbing each of them is that adjacent houses have security system connected and it will 
 * automatically contact the police if two adjacent houses were broken into on the same 
 * night.
 * 
 * Given a list of non-negative integers representing the amount of money of each house, 
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * @author zwb
 *
 */
public class HouseRobber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(4);
		TreeNode node3 = new TreeNode(5);
		TreeNode node4 = new TreeNode(3);
		TreeNode node5 = new TreeNode(3);
		TreeNode node6 = new TreeNode(1);
		TreeNode node7 = new TreeNode(2);
		TreeNode node8 = new TreeNode(3);
		TreeNode node9 = new TreeNode(1);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		
		node4.right = node8;
		
		node7.left = node9;
		
		//int[] nums = new int[]{2,1,1,2};
		System.out.println(rob3(node1));

	}
	
	public static int rob(int[] nums){
		if(nums == null || nums.length == 0)
			return 0;
		int[] mount = new int[nums.length + 1];
		mount[0] = 0;
		mount[1] = nums[0];
		
		for(int i = 2;i < mount.length;i++){
			mount[i] = Math.max(mount[i-1], nums[i-1] + mount[i-2]);
		}
		
		return mount[nums.length];
	}
	
	//if the houses are arranged in a circle.
	public static int rob2(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		if (nums.length == 2) {
			return Math.max(nums[0], nums[1]);
		}
		int start = robStartOrEnd(nums, 0);
		int end = robStartOrEnd(nums, 1);
		return start > end ? start : end;
	}

	public static int robStartOrEnd(int[] nums, int start) {
		int n = nums.length;
		if (start == 0) {
			n = nums.length - 1;
		}
		int[] dp = new int[n];
		dp[start] = nums[start];
		dp[start + 1] = Math.max(nums[start], nums[start + 1]);
		for (int i = start + 2; i < n; i++) {
			dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
		}
		return dp[n - 1];
	}
	
	/**
	 *  The thief has found himself a new place for his thievery again. There is only one entrance to this area, 
	 *  called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart 
	 *  thief realized that "all houses in this place forms a binary tree". It will automatically contact the police 
	 *  if two directly-linked houses were broken into on the same night.
	 *  
	 *  Determine the maximum amount of money the thief can rob tonight without alerting the police
	 *  
	 * @param root
	 * @return
	 */
	public static int rob3(TreeNode root) {
		
		return helper(root).total;
    }
	static class Item{
		int total;
		int childrenTotal;
		boolean used;
		
		Item(int total,int childrenTotal,boolean used){
			this.total = total;
			this.childrenTotal = childrenTotal;
			this.used = used;
		}
	}
	private static Item helper(TreeNode root){
		if(root == null)
			return new Item(0,0,true);
		int currentVal = root.val;
		
		Item left = helper(root.left);
		Item right = helper(root.right);
		
		int childrenChildrenSum = left.childrenTotal + right.childrenTotal;
		int childrenSum = left.total + right.total;
		
		if(left.used || right.used){
			if(currentVal + childrenChildrenSum > childrenSum){
				return new Item(currentVal + childrenChildrenSum,childrenSum,true);
			}
			else{
				return new Item(childrenSum,childrenSum,false);
			}
		}
		else{
			return new Item(currentVal + childrenChildrenSum,childrenSum,true);
		}
		
		/*else{
			if(currentVal + left.childrenTotal + right.childrenTotal > left.total + right.total){
				return new Item(currentVal + left.childrenTotal + right.childrenTotal,left.total + right.total,true);
			}
			else{
				return new Item(left.total + right.total,left.total + right.total,false);
			}
		}*/
	}
}
