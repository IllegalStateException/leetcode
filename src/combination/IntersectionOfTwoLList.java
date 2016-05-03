package combination;

import prepared.ListNode;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3

begin to intersect at node c1.

Notes:

    If the two linked lists have no intersection at all, return null.
    The linked lists must retain their original structure after the function returns.
    You may assume there are no cycles anywhere in the entire linked structure.
    Your code should preferably run in O(n) time and use only O(1) memory.

 * @author zwb
 *
 */
public class IntersectionOfTwoLList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
        	return null;
        int lengthA = 0,lengthB = 0;
        ListNode temp = headA;
        while(temp != null){
        	lengthA++;
        	temp = temp.next;
        }
        temp = headB;
        while(temp != null){
        	lengthB++;
        	temp = temp.next;
        }
        int diffValue;
        if(lengthA > lengthB){
        	diffValue = lengthA - lengthB;
        	while(diffValue > 0){
        		headA = headA.next;
        		diffValue--;
        	}
        }
        else{
        	diffValue = lengthB - lengthA;
        	while(diffValue > 0){
        		headB = headB.next;
        		diffValue--;
        	}
        }
        while(headA != null){
        	if(headA == headB)
        		return headA;
        	headA = headA.next;
        	headB = headB.next;
        }
        return null;
    }
}
