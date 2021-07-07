package com.learning.dsa.linkedlist.common;

public class DoublyLinkedList {

	public static DoubleListNode head, tail;

	public static DoubleListNode createDoublyLinkedList(int[] array) {
		DoubleListNode temp = null, prev = null;
		for (int num : array) {
			if (head == null) {
				head = new DoubleListNode(num);
				temp = head;
				continue;
			}
			temp.next = new DoubleListNode(num);
			temp.previous = prev;
			prev = temp;
			temp = temp.next;
		}
		temp.previous = prev;
		tail = temp;
		return head;
	}

	public static void print() {
		DoubleListNode temp = head;
		while (temp != null) {
			System.out.print(temp.data + " --> ");
			temp = temp.next;
		}
		System.out.print("null\n");
	}

	public static void printReverse() {
		DoubleListNode temp = tail;
		while (temp != null) {
			System.out.print(temp.data + " --> ");
			temp = temp.previous;
		}
		System.out.print("null\n");
	}

}
