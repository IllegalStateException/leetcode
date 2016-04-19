package combination;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import prepared.NestedInteger;

public class NestedIterator implements Iterator<Integer> {
	
	private ArrayDeque<Integer> stack = new ArrayDeque<>();
	
	public NestedIterator(List<NestedInteger> nestedList){
		//this.nestedList = nestedList;
		iterator(nestedList);
		
	}
	
	private void iterator(List<NestedInteger> list){
		
		for(ListIterator<NestedInteger> it = list.listIterator(list.size());it.hasPrevious();){
			pushStack(it.previous());
		}
	}
	private void pushStack(NestedInteger nestedInteger){
		if(nestedInteger.isInteger()){
			stack.push(nestedInteger.getInteger());
			return;
		}
		iterator(nestedInteger.getList());
		
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return stack.size() > 0;
		
	}

	@Override
	public Integer next() {
		// TODO Auto-generated method stub
		return stack.pop();
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}

}
