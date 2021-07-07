package com.learning.dsa.linkedlist.common;

public class SinglyLinkedList {
	
	public static SingleListNode head;
	
	public static void createSinglyLinkedList(int[] array) {
		SingleListNode temp = null;
		for(int num:array) {
			if(head == null) {
				head = new SingleListNode(num);
				temp = head;
				continue;
			}
			temp.next = new SingleListNode(num);
			temp = temp.next;
		}
	}
	
	public static void print() {
		SingleListNode temp = head;
		while (temp != null) {
			System.out.print(temp.data+" --> ");
			temp = temp.next;
		}
		System.out.print("null\n");
	}

}
