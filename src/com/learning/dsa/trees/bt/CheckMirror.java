package com.learning.dsa.trees.bt;

import com.learning.dsa.trees.TreeNode;

public class CheckMirror {

	public static void main(String[] args) {
		BinaryTree tree1 = new BinaryTree();
		tree1.createBinaryTree(new int[] { 1, 2, 3, 4, 5, 6, 7 });
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(3);
		root2.right = new TreeNode(2);
		root2.left.left = new TreeNode(7);
		root2.left.right = new TreeNode(6);
		root2.right.left = new TreeNode(5);
		root2.right.right = new TreeNode(4);
		BinaryTree.levelOrderTraversal(tree1.root);
		System.out.println();
		BinaryTree.levelOrderTraversal(root2);
		System.out.println("\n" + isMirror(tree1.root, root2));

	}

	static boolean isMirror(TreeNode root1, TreeNode root2) {

		if (root1 == null && root2 == null) {
			return true;
		}

		if (root1 == null && root2 != null) {
			return false;
		}

		if (root1 != null && root2 == null) {
			return false;
		}

		return (root1.data == root2.data) && 
				isMirror(root1.left, root2.right) && 
				isMirror(root1.right, root2.left);
	}
}
