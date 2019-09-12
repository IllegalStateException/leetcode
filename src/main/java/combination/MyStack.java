package combination;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MyStack {
	
	private Deque<Integer> queue = new ArrayDeque<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStack stack = new MyStack();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		System.out.println(stack.empty());
		System.out.println(stack.top());
		stack.pop();
		System.out.println(stack.top());

	}
	
	// Push element x onto stack.
    public void push(int x) {
        List<Integer> list = new ArrayList<>(queue.size());
        
        while(!queue.isEmpty()){
        	list.add(queue.poll());
        }
        queue.offer(x);
        for(int i : list){
        	queue.offer(i);
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue.poll();
    }

    // Get the top element.
    public int top() {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.size() == 0;
    }

}
