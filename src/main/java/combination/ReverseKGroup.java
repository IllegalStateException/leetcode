package combination;

import prepared.ListNode;

public class ReverseKGroup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseKGroup rkg = new ReverseKGroup();
		
		ListNode node1 = new ListNode(1);
		//ListNode node2 = new ListNode(2);
		/*ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);*/
		
		//node1.next = node2;
		/*node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;*/
		
		ListNode head = rkg.reverseKGroup(node1,1);
		
		for(ListNode temp = head;temp != null;temp = temp.next){
			System.out.println(temp.value);
		}
		
	}
	
	
	public ListNode reverseKGroup(ListNode head, int k) {
		
		if(head == null)
			return null;
		if(k == 1)
			return head;
       
		ListNode headNode = new ListNode(Integer.MAX_VALUE);
		int i = 1;
		ListNode preNode = headNode;
		ListNode subquenceHead = head;
		
		for(ListNode temp = head;temp != null;temp = temp.next){
			if(i % k == 0){
				reverse(subquenceHead,k,preNode);
				preNode = subquenceHead;
				temp = subquenceHead;
			}
			else if(i % k == 1){
				subquenceHead = temp;
			}
			i++;
		}
		if(i-1 < k)
			return head;
		return headNode.next;
    }
	
	private void reverse(ListNode head,int k,ListNode preNode){
		ListNode pre = head;
		ListNode next = pre.next;
		ListNode newHead = head;
		
		for(int i = 0;i < k-1;i++){
			
			pre.next = next.next;
			next.next = newHead;
			
			newHead = next;
			
			next = pre.next;
		}
		
		preNode.next = newHead;
	}
}
