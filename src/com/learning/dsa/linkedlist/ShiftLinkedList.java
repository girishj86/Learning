package com.learning.dsa.linkedlist;

import com.learning.dsa.linkedlist.common.SingleListNode;
import com.learning.dsa.linkedlist.common.SinglyLinkedList;

public class ShiftLinkedList {

	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.createSinglyLinkedList(new int[] { 0, 1, 2, 3, 4, 5 });
		SinglyLinkedList.print(sll.head);
		SinglyLinkedList.print(shiftLinkedList(sll.head, 8));

	}

	static SingleListNode shiftLinkedList(SingleListNode head, int k) {
		// 1 -> 2 -> 3 -> 4 -> 5
		// 4 -> 5 -> 1 -> 2 -> 3 if k=2
		// 3 -> 4 -> 5 -> 1 -> 2 if k=-2
		if (k == 0)
			return head;
		
		SingleListNode newHead = head, temp = head, newTail = null, oldTail = null;
		int length = 0;
		// find original/old tail
		while (temp != null) {
			oldTail = temp;
			temp = temp.next;
			length++;
		}
		temp = head;
		if (k > 0) {
			k = k % length;
			if (k == 0)
				return head;
			while (k-- != 0) {
				temp = temp.next;
			}
			while (temp != null) {
				newTail = newHead;
				newHead = newHead.next;
				temp = temp.next;
			}
			newTail.next = null;
			oldTail.next = head;
			return newHead;
		} else {
			k = Math.abs(k);
			k = k % length;
			if (k == 0)
				return head;
			while (k-- != 0) {
				newTail = temp;
				temp = temp.next;
			}
			if (temp == null) {
				return head;
			}
			newHead = temp;
			newTail.next = null;
			oldTail.next = head;
			return newHead;
		}
	}

}
