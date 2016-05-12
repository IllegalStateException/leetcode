package combination;

import prepared.ListNode;

/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes. 
 * Please note here we are talking about the node number and not the value in the nodes.
 * 
 * You should try to do it in place. The program should run in O(1) space complexity 
 * and O(nodes) time complexity.
 * 
 * Example:
 * 
 * Given 1->2->3->4->5->NULL
 * return 1->3->5->2->4->NULL.
 * 
 * Note:
 * The relative order inside both the even and odd groups should remain as it was in the 
 * input.
 * 
 * The first node is considered odd, the second node even and so on ... 
 * @author zwb
 *
 */
public class OddEvenLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		
		for(ListNode node = oddEvenList(node1);node != null;node = node.next)
			System.out.println(node.value);
		
		
	}
	
	public static ListNode oddEvenList(ListNode head) {
        
		ListNode evenHead;
		
		if(head == null || (evenHead = head.next) == null)
			return head;
		ListNode pre = head;
		for(ListNode start = evenHead.next; start != null;){
			
			ListNode temp = evenHead.next == null ? null :evenHead.next.next;
			ListNode startTemp = start.next == null ? null :start.next.next;
			
			evenHead.next = start.next;
			start.next = pre.next;
			pre.next = start;
			
			pre = start;
			
			start = startTemp;
			evenHead = temp;
		}
		
		return head;
    }
}
