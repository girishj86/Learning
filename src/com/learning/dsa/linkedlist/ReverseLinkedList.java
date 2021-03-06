package com.learning.dsa.linkedlist;

import com.learning.dsa.linkedlist.common.DoubleListNode;
import com.learning.dsa.linkedlist.common.DoublyLinkedList;
import com.learning.dsa.linkedlist.common.SingleListNode;
import com.learning.dsa.linkedlist.common.SinglyLinkedList;

public class ReverseLinkedList {

	public static void main(String[] args) {
		SinglyLinkedList sll1 = new SinglyLinkedList();
		sll1.createSinglyLinkedList(new int[] {1,2,3,4});
		SinglyLinkedList.print(sll1.head);
		printReverseRecursively(sll1.head);
		SinglyLinkedList.print(reverseSinglyLinkedList(sll1.head));
		
//		DoublyLinkedList.createDoublyLinkedList(new int[] {1,2,3,4});
//		DoublyLinkedList.print(DoublyLinkedList.head);
//		DoubleListNode temp = DoublyLinkedList.head;
//		DoublyLinkedList.head = reverseDoublyLinkedList(DoublyLinkedList.head);
//		DoublyLinkedList.tail = temp;
//		DoublyLinkedList.print(DoublyLinkedList.head);
//		DoublyLinkedList.printReverse(DoublyLinkedList.tail);
//	
//		DoubleListNode first = new DoubleListNode(1);
//		DoubleListNode second = new DoubleListNode(2);
//		DoubleListNode third = new DoubleListNode(3);
//		DoubleListNode fourth = new DoubleListNode(4);
//		first.next = second;
//		//second.next = third;
//		second.previous = first;
//		third.next = fourth;
//		third.previous = second;
//		fourth.previous = third;
//		DoublyLinkedList.head = first;
//		DoublyLinkedList.print();
//		reverseDoublyLinkedList(null);
//		DoublyLinkedList.head = first;
//		DoublyLinkedList.print();
		
		

	}
	
	static SingleListNode reverseSinglyLinkedList(SingleListNode head) {
		SingleListNode cur = head, prev = null, temp = head;
		while(temp != null) {
			temp = temp.next;
			cur.next = prev;
			prev = cur;
			cur = temp;
		}
		return prev;
	}
	
	static DoubleListNode reverseDoublyLinkedList(DoubleListNode head) {
		DoubleListNode cur = head, prev = null, temp = head;
		while(temp != null) {
			temp = temp.next;
			cur.next = prev;
			cur.previous = temp;
			prev = cur;
			cur = temp;
		}
		return prev;
	}
	
	static void printReverseRecursively(SingleListNode head) {
		if(head == null) {
			System.out.print("null");
			return;
		}
		printReverseRecursively(head.next);
		System.out.print(" --> "+head.data);
	}

}

