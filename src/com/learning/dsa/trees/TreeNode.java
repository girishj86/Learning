package com.learning.dsa.trees;

public class TreeNode {

	int data;
	TreeNode left, right;

	TreeNode(int data) {
		this.data = data;
		left = null;
		right = null;
	}

	@Override
	public String toString() {
		return data+" ";
	}
	
	

}
