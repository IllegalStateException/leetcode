package combination;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import prepared.TreeNode;

public class TreePostorder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		//TreeNode node4 = new TreeNode(4);
		//TreeNode node5 = new TreeNode(5);
		
		node1.right = node2;
		node2.left = node3;
		//node3.left = node4;
		//node3.right = node5;
		
		System.out.println(postorderTraversal(node1));

	}
	
	public static List<Integer> postorderTraversal(TreeNode root){
		Deque<TreeNode> stack = new ArrayDeque<>();
		
		List<Integer> result = new ArrayList<>();
		if(root == null)
			return result;
		
		stack.push(root);
		
		TreeNode temp;
		while((temp = stack.peek()) != null){
			if(temp.right != null || temp.left != null){
				if (temp.right != null) {
					stack.push(temp.right);
					temp.right = null;
				}
				if(temp.left != null){
					stack.push(temp.left);
					temp.left = null;
				}
			}
			else{
				result.add(stack.pop().val);
			}
		}
		
		return result;
		
	}

}
