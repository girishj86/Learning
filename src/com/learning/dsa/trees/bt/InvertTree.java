package com.learning.dsa.trees.bt;

import java.util.LinkedList;
import com.learning.dsa.trees.TreeNode;

public class InvertTree {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.createBinaryTree(new int[] { 1, 2, 3, 4, 5, 6, 7 });
		BinaryTree.levelOrderTraversal(tree.root);
		invert(tree.root);
		BinaryTree.levelOrderTraversal(tree.root);
		levelOrderInvert(tree.root);
		BinaryTree.levelOrderTraversal(tree.root);

	}

	static void invert(TreeNode node) {
		if (node == null) {
			return;
		}

		TreeNode temp = node.left;
		node.left = node.right;
		node.right = temp;

		invert(node.left);
		invert(node.right);
	}

	static void levelOrderInvert(TreeNode root) {
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				TreeNode temp = node.left;
				node.left = node.right;
				node.right = temp;
				if (node != null) {
					if (node.left != null) {
						queue.offer(node.left);
					}
					if (node.right != null) {
						queue.offer(node.right);
					}
				}
			}
		}
	}
}
