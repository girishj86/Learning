package com.learning.dsa.linkedlist.common;

public class DoubleListNode {
	public int data;
	public DoubleListNode previous, next;

	public DoubleListNode(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return data + "";
	}

}
