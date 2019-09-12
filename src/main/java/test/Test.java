package test;

import java.util.ArrayList;
import java.util.List;

import combination.NestedIterator;
import prepared.IntegerImpl;
import prepared.ListImpl;
import prepared.NestedInteger;

public class Test {
	
	public static void main(String[] args){
		List<NestedInteger> list = new ArrayList<>();
		
		NestedInteger ni1 = new IntegerImpl(1);
		NestedInteger ni2 = new IntegerImpl(1);
		NestedInteger ni3 = new IntegerImpl(2);
		
		List<NestedInteger> list2 = new ArrayList<>();
		List<NestedInteger> list3 = new ArrayList<>();
		
		list2.add(ni1);
		list2.add(ni2);
		
		list3.add(ni1);
		list3.add(ni2);
		
		NestedInteger nestInteger1 = new ListImpl(list2);
		NestedInteger nestInteger2 = new ListImpl(list3);
		
		list.add(nestInteger1);
		list.add(ni3);
		list.add(nestInteger2);
		
		NestedIterator iterator = new NestedIterator(list);
		
		while(iterator.hasNext()){
			System.out.print(iterator.next());
		}
		
		
	}
}
