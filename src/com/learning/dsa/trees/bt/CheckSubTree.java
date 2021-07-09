package com.learning.dsa.trees.bt;

import com.learning.dsa.trees.TreeNode;

public class CheckSubTree {

	public static void main(String[] args) {
		BinaryTree tree1 = new BinaryTree();
		tree1.createBinaryTree(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 });
		BinaryTree tree2 = new BinaryTree();
		tree2.createBinaryTree(new int[] { 3, 6, 7, 12, 13, 14, 15 });
		System.out.println(isSubtree(tree1.root, tree2.root));

	}

	static boolean isSubtree(TreeNode root1, TreeNode root2) {

		if (root1 == null && root2 != null) {
			return false;
		}
		if (root2 == null && root1 != null) {
			return false;
		}
		if (root1 == null && root2 == null) {
			return true;
		}

		if (CheckIdenticalTrees.checkIdenticalTree(root1, root2)) {
			return true;
		}
		return isSubtree(root1.left, root2) || isSubtree(root1.right, root2);
	}
}
