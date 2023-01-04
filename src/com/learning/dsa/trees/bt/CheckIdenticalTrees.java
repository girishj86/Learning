package com.learning.dsa.trees.bt;

import com.learning.dsa.trees.TreeNode;

public class CheckIdenticalTrees {

	public static void main(String[] args) {
		BinaryTree tree1 = new BinaryTree();
		tree1.createBinaryTree(new int[] {1,2,3,4,5,6,7,8,9});
		BinaryTree tree2 = new BinaryTree();
		tree2.createBinaryTree(new int[] {1,2,3,4,5,6,7,8,9});
		System.out.println(checkIdenticalTree(tree1.root, tree2.root));
	}
	
	/* Function to check if 2 trees are identical */
	static boolean checkIdenticalTree(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 != null) {
			return false;
		}
		if (root2 == null && root1 != null) {
			return false;
		}
		if (root1 == null && root2 == null) {
			return true;
		}

		return (root1.data == root2.data) && checkIdenticalTree(root1.left, root2.left) && checkIdenticalTree(root1.right, root2.right);

	}

}
