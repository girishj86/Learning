package com.learning.dsa.linkedlist;

import com.learning.dsa.linkedlist.common.SingleListNode;
import com.learning.dsa.linkedlist.common.SinglyLinkedList;

public class FindLoop {

	public static void main(String[] args) {
		SingleListNode head = new SingleListNode(1);
		head.next = new SingleListNode(2);
		head.next.next = new SingleListNode(3);
		SingleListNode loopNode = new SingleListNode(4);
		head.next.next.next = loopNode;
		head.next.next.next.next = new SingleListNode(5);
		head.next.next.next.next.next = new SingleListNode(6);
		head.next.next.next.next.next.next = new SingleListNode(7);
		SingleListNode tail = new SingleListNode(8);
		head.next.next.next.next.next.next.next = tail;
		tail.next = loopNode;
		//SinglyLinkedList.print(head);
		System.out.println(findLoop(head).data);
	}

	public static SingleListNode findLoop(SingleListNode head) {
		SingleListNode fp = head, sp = head;
		if (fp != null && fp.next != null) {
			fp = fp.next.next;
		}
		if (sp != null) {
			sp = sp.next;
		}
		while (fp != sp) {
			if (fp != null && fp.next != null) {
				fp = fp.next.next;
			}
			if (sp != null) {
				sp = sp.next;
			}
		}
		fp = head;
		while (fp != sp) {
			if (fp != null) {
				fp = fp.next;
			}
			if (sp != null) {
				sp = sp.next;
			}
		}
		if(fp==null) {
			System.out.println("No loop found");
		}
		return fp;
	}
}
