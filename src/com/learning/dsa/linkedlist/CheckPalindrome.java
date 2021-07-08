package com.learning.dsa.linkedlist;

import com.learning.dsa.linkedlist.common.SingleListNode;
import com.learning.dsa.linkedlist.common.SinglyLinkedList;

public class CheckPalindrome {

	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.createSinglyLinkedList(new int[] { 1,2,2 });
		System.out.println(linkedListPalindrome(sll.head));
	}

	static boolean linkedListPalindrome(SingleListNode head) {
		if(head.next == null) return true;
		SingleListNode fp = head, sp = head, firstHalfTail = null;

		while (fp != null && fp.next != null) {
			fp = fp.next.next;
			firstHalfTail = sp;
			sp = sp.next;
		}
		firstHalfTail.next = null;

		SingleListNode temp = sp, cur = sp, prev = null, secondHalfHead = null;
		while (temp != null) {
			temp = temp.next;
			cur.next = prev;
			prev = cur;
			cur = temp;
		}

		secondHalfHead = prev;
		while (head != null) {
			if (head.data != secondHalfHead.data) {
				return false;
			}
			head = head.next;
			secondHalfHead = secondHalfHead.next;
		}
		return true;

	}

}
