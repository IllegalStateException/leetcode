package combination;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Verify Preorder Serialization of a Binary Tree  
 * @author zwb
 *
 */
public class ValidPreOrderBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidPreOrderBinary vp = new ValidPreOrderBinary();
		
		System.out.println(vp.isValidSerialization("#,#,#"));

	}
	class Item{
		String node;
		boolean hasLeft;
		
		Item(String node,boolean hasLeft){
			this.node = node;
			this.hasLeft = hasLeft;
		}
	}
	/**
	 * solution with stack
	 * @param preorder
	 * @return
	 */
	public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        
        Deque<Item> stack = new ArrayDeque<>();
        
        String nullValue = "#";
        
        if(nodes[0].equals(nullValue)){
        	return nodes.length == 1;
        }
      
        stack.push(new Item(nodes[0],false));
       
    
        for(int i = 1;i < nodes.length;i++){
        	if(nullValue.equals(nodes[i])){
				Item parent;

				while ((parent = stack.peek()) != null && parent.hasLeft) {
					stack.pop();
				}
				if (parent == null && i != nodes.length-1)
					return false;
				else if(parent != null){
					parent.hasLeft = true;
				}
				
        	}
        	else{
        		stack.push(new Item(nodes[i],false));
        	}
        }
        return stack.isEmpty();
    }
	
	/**
	 * solution with string split
	 * 用到的性质,null节点要比非null节点多1
	 * @param preorder
	 * @return
	 */
	public boolean isValidSerialization2(String preorder){
		
		String[] nodes = preorder.split(",");
		
		int nullCount = 0,nodeCount = 0;
		
		for(String str : nodes){
		
			if("#".equals(str))
				nullCount++;
			else
				nodeCount++;
			if(nullCount - nodeCount >= 1 && nullCount + nodeCount != nodes.length)
			    return false;
		}
		
		return nullCount - nodeCount == 1;
	}
	
	public boolean isValidSerialization3(String preorder){
		
		char[] chars = preorder.toCharArray();
	
		int nullCount = 0,nodeCount = 0;
		
		for(int i = 0;i < chars.length;i++){
			if(',' == chars[i])
				continue;
			else if('#' == chars[i])
				nullCount++;
			else{
				nodeCount++;
				while(chars[i+1] != ',')
					i++;
			}
			if(nullCount >= nodeCount+1 && i != chars.length - 1)
				return false;
		}
		
		return nullCount - nodeCount == 1;
	}
}
