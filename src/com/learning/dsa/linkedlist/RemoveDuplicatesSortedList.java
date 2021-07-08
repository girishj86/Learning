package com.learning.dsa.linkedlist;

import com.learning.dsa.linkedlist.common.SingleListNode;
import com.learning.dsa.linkedlist.common.SinglyLinkedList;

public class RemoveDuplicatesSortedList {

	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.createSinglyLinkedList(new int[] { 1, 1, 3, 4, 4, 4, 5, 6, 6, 6, 6,7 });
		SingleListNode head = removeDuplicatesSortedList(sll.head);
		SinglyLinkedList.print(head);
	}

	public static SingleListNode removeDuplicatesSortedList(SingleListNode head) {
		SingleListNode cur = head.next, prev = head;
		while (cur != null) {
			if (prev.data != cur.data) {
				prev.next = cur;
				prev = cur;
			}
			cur = cur.next;
		}
		if (prev.next != null && prev.data == prev.next.data) {
			prev.next = null;
		}
		return head;
	}

}
