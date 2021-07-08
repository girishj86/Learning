package com.learning.dsa.linkedlist;

import com.learning.dsa.linkedlist.common.SingleListNode;
import com.learning.dsa.linkedlist.common.SinglyLinkedList;

public class RemoveKthNodeFromEnd {

	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.createSinglyLinkedList(new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		SingleListNode head = removeKthNodeFromEnd(sll.head, 2);
		SinglyLinkedList.print(head);
	}

	public static SingleListNode removeKthNodeFromEnd(SingleListNode head, int k) {
		SingleListNode fp = head, sp = head, prev = null;
		while (k-- != 0) {
			if (fp == null) {
				return head;
			}
			fp = fp.next;
		}
		while (fp != null) {
			prev = sp;
			fp = fp.next;
			sp = sp.next;
		}
		if (prev != null && sp != null) {
			prev.next = sp.next;
		}
		if (sp == head) {
			head = sp.next;
		}
		return head;
	}
}
