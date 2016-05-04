package combination;

import java.util.ArrayDeque;
import java.util.Deque;

import prepared.TreeNode;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored
 *  in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same 
 *  or another computer environment.
 *  
 *  Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your 
 *  serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to 
 *  a string and this string can be deserialized to the original tree structure.
 *  
 *  For example, you may serialize the following tree

    1
   / \
  2   3
     / \
    4   5

	as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need 
	to follow this format, so please be creative and come up with different approaches yourself.

	Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms 
	should be stateless. 
 * @author zwb
 *
 */
public class SerAndDesBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(1);
		TreeNode node5 = new TreeNode(3);
		TreeNode node6 = new TreeNode(2);
		TreeNode node7 = new TreeNode(4);
		
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		//node2.right = node4;
		node3.left = node6;
		node3.right = node7;
		
		System.out.println(serialize2(node1));
		System.out.println(deserialize2(serialize2(node1)).val);
		System.out.println(2.5e+001);
		
	}
	
	/**
	 * 解法一：27ms,后续遍历解法.
	 */
	// Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
    	StringBuilder sb = new StringBuilder();
    	
    	helper(root,sb);
        String result = sb.toString();
    	return result.substring(0, result.length()-1);
    }
    
    private static void helper(TreeNode root,StringBuilder sb){
    	if(root == null){
    		sb.append("null").append(",");
    	}
    	else if(root.left == null && root.right == null){
    		sb.append(root.val).append(",");
    	}
    	else{
			helper(root.left, sb);
			helper(root.right, sb);
			sb.append(root.val).append("#,");

    	}
    	
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if("null".equals(data))
        	return null;
        Deque<TreeNode> nodeStack = new ArrayDeque<>();
        
        String[] values = data.split(",");
        
        for(String value : values){
        	if("null".equals(value)){
        		nodeStack.push(new TreeNode(Integer.MAX_VALUE));
        	}
        	else{
				if (value.endsWith("#")) {
					TreeNode node = new TreeNode(Integer.parseInt(value.substring(0, value.length()-1)));
					TreeNode temp;
					node.right = (temp = nodeStack.pop()).val == Integer.MAX_VALUE ? null : temp;
					node.left = (temp = nodeStack.pop()).val == Integer.MAX_VALUE ? null : temp;

					nodeStack.push(node);
				}
				else{
					nodeStack.push(new TreeNode(Integer.parseInt(value)));
				}
        	}
        }
        return nodeStack.pop();
    }
    
    public static String serialize2(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        _serialize(root, sb);
        return sb.toString();
    }

    private static void _serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
        } else {
            sb.append(root.val);
            sb.append(",");
            _serialize(root.left, sb);
            _serialize(root.right, sb);
        }
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public static TreeNode deserialize2(String data) {
        TreeNode dummy = new TreeNode(-1);
        _deserialize(dummy, true, data, 0);
        return dummy.left;
    }

    private static int _deserialize(TreeNode root, boolean left, String data, int start) {
        if (start < data.length() && data.charAt(start) != '#') {
            int end = start + 1;
            while (data.charAt(end) != ',') {
                ++end;
            }
            TreeNode node = new TreeNode(Integer.parseInt(data.substring(start, end)));
            if (left) {
                root.left = node;
            } else {
                root.right = node;
            }
            int deserialized = _deserialize(node, true, data, end + 1);
            return _deserialize(node, false, data, deserialized + 1);
        }
        return start + 1;
    }
}