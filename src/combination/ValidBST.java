package combination;

import prepared.TreeNode;

public class ValidBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(10);
		TreeNode node2 = new TreeNode(5);
		TreeNode node3 = new TreeNode(15);
		TreeNode node4 = new TreeNode(6);
		TreeNode node5 = new TreeNode(20);
		
		node1.left = node2;
		node1.right = node3;
		node3.left = node4;
		node3.right = node5;
		
		ValidBST validBST = new ValidBST();
		System.out.println(validBST.isValidBST(node1));
		

	}
	
	public boolean isValidBST(TreeNode root){
		if(root == null)
			return true;
		if(root.left == null && root.right == null)
			return true;
		else if(root.left == null)
			return root.right.val > root.val && isRightValid(root.right,root.val) && isValidBST(root.right);
		else if(root.right == null)
			return root.left.val < root.val && isLeftValid(root.left,root.val) && isValidBST(root.left);
		else
			return root.right.val > root.val && root.left.val < root.val && isRightValid(root.right,root.val) && isValidBST(root.right)
					&& isLeftValid(root.left,root.val) && isValidBST(root.left);
	}
	
	private boolean isLeftValid(TreeNode root,int val){
		if(root == null){
			return true;
		}
		return root.val < val && isLeftValid(root.left,val) && isLeftValid(root.right,val);
	}
	
	private boolean isRightValid(TreeNode root,int val){
		if(root == null){
			return true;
		}
		return root.val > val && isRightValid(root.left,val) && isRightValid(root.right,val);
	}
	
	public boolean isValidBST_solution2(TreeNode root){
		return isValidUtil(root, Long.MAX_VALUE, Long.MIN_VALUE);
	}
	
	private boolean isValidUtil(TreeNode root,long max,long min){
		if(root == null){
			return true;
		}
		if(root.val >= max || root.val <= min)
			return false;
		return isValidUtil(root.left,root.val, min) && isValidUtil(root.right, max,root.val);
	}

}
