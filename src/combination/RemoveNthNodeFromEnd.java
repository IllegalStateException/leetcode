package combination;

import java.util.ArrayList;
import java.util.List;

import prepared.ListNode;

public class RemoveNthNodeFromEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null)
			return null;
		List<ListNode> nodes = new ArrayList<>();

		for (ListNode temp = head; temp != null; temp = temp.next) {
			nodes.add(temp);
		}
		int length = nodes.size();
		ListNode current = nodes.get(length - n);
		current.next = null;
		current = null;

		if (length == n) {
			if (length == 1)
				return null;
			return nodes.get(1);
		}
		if (n == 1) {
			ListNode pre = nodes.get(length - n - 1);
			pre.next = null;
		} else {
			ListNode pre = nodes.get(length - n - 1);
			ListNode next = nodes.get(length - n + 1);
			pre.next = next;
		}
		return nodes.get(0);
    }

}
