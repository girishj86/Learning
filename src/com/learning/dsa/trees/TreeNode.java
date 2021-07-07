package com.learning.dsa.trees;

public class TreeNode {

	public int data;
	public TreeNode left, right;

	public TreeNode(int data) {
		this.data = data;
		left = null;
		right = null;
	}

	@Override
	public String toString() {
		return data + " ";
	}
}
