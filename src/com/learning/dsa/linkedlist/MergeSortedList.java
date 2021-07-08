package com.learning.dsa.linkedlist;

import com.learning.dsa.linkedlist.common.SingleListNode;
import com.learning.dsa.linkedlist.common.SinglyLinkedList;

public class MergeSortedList {

	public static void main(String[] args) {
		SinglyLinkedList sll1 = new SinglyLinkedList();
		sll1.createSinglyLinkedList(new int[] { 1, 1, 3, 5 });
		SinglyLinkedList sll2 = new SinglyLinkedList();
		sll2.createSinglyLinkedList(new int[] { 2, 2, 4, 6 });
		SinglyLinkedList.print(sll1.head);
		SinglyLinkedList.print(sll2.head);
		SinglyLinkedList.print(mergeTwoLists(sll1.head, sll2.head));
	}

	public static SingleListNode mergeTwoLists(SingleListNode l1, SingleListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		// temporary head
		SingleListNode head = new SingleListNode(0);
		SingleListNode p = head;

		SingleListNode p1 = l1;
		SingleListNode p2 = l2;
		while (p1 != null && p2 != null) {
			if (p1.data < p2.data) {
				p.next = p1;
				p1 = p1.next;
			} else {
				p.next = p2;
				p2 = p2.next;
			}
			p = p.next;
		}

		if (p1 != null) {
			p.next = p1;
		}

		if (p2 != null) {
			p.next = p2;
		}

		return head.next;
	}
}
