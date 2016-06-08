package combination;

import prepared.ListNode;

public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(5);
		/*ListNode l1Node2 = new ListNode(4);
		ListNode l1Node3 = new ListNode(3);
		l1.next = l1Node2;
		l1Node2.next = l1Node3;*/
		
		ListNode l2 = new ListNode(5);
		/*ListNode l2Node2 = new ListNode(6);
		ListNode l2Node3 = new ListNode(6);
		ListNode l2Node4 = new ListNode(4);*/
		/*l2.next = l2Node2;
		l2Node2.next = l2Node3;
		l2Node3.next = l2Node4;*/
		
		AddTwoNumbers atn = new AddTwoNumbers();
		
		ListNode list = atn.addTwoNumbers(l1, l2);
		
		for(ListNode temp = list;temp != null;temp = temp.next){
			System.out.println(temp.value);
		}
		

	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        boolean hasCarry = false;
        ListNode currentNode = head;
        ListNode list1 = l1,list2 = l2;
        
		for(;list1 != null && list2 != null;list1 = list1.next,
				list2 = list2.next){
			int value = list1.value + list2.value + (hasCarry ? 1 : 0);
			if(value >= 10){
				value -= 10;
				hasCarry = true;
			}
			else
				hasCarry = false;
			ListNode node = new ListNode(value);
			currentNode.next = node;
			currentNode = node;
		}
		ListNode temp = list1 == null ? list2 : list1;
		if(temp != null){
			for(;temp != null;temp = temp.next){
				int value = temp.value + (hasCarry ? 1 : 0);
				if(value >= 10){
					value -= 10;
					hasCarry = true;
				}
				else
					hasCarry = false;
				ListNode node = new ListNode(value);
				currentNode.next = node;
				currentNode = node;
			}
			if(hasCarry){
				ListNode node = new ListNode(1);
				currentNode.next = node;
			}
		}
		else if(hasCarry){
			ListNode node = new ListNode(1);
			currentNode.next = node;
		}
		return head.next;
    }

}
