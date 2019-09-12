package combination;

import prepared.ListNode;

/**
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 * @author zwb
 *
 */
public class PalindromeLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(4);
		ListNode node3 = new ListNode(-1);
		ListNode node4 = new ListNode(-1);
		ListNode node5 = new ListNode(4);
		ListNode node6 = new ListNode(1);
		
		node1.next = node2; node2.next = node3;
		node3.next = node4; node4.next = node5;
		node5.next = node6;
		
		System.out.println(isPalindrome(node1));

	}
	
	public static boolean isPalindrome(ListNode head) {
		if(head == null || head.next == null)
			return true;
		ListNode node = null;
		int length = 0;
		
		//temp.next = head.next;
		for (ListNode temp = head; temp != null; temp = temp.next) {
			ListNode reverse = new ListNode(temp.value);
			
			reverse.next = node;
			node = reverse;
			length++;
		}
		
		for(int i = 0;i < length/2;i++){
			if(head.value != node.value)
				return false;
			head = head.next;
			node = node.next;
		}
		
		return true;
		
    }
}
