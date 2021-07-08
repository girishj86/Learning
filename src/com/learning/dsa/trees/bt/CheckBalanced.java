package com.learning.dsa.trees.bt;

import com.learning.dsa.trees.TreeNode;

public class CheckBalanced {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(4);
		System.out.println(isBalanced(root));
		BinaryTree tree = new BinaryTree();
		tree.createBinaryTree(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 });
		System.out.println(isBalanced(tree.root));


	}
	
	static boolean isBalanced(TreeNode node) {
		if(node == null) {
			return true;
		}
		int lh = BinaryTree.height(node.left);
		int rh = BinaryTree.height(node.right);
		
		return (Math.abs(lh-rh) <=1 && isBalanced(node.left) && isBalanced(node.right));
	}

}
