package com.learning.dsa.trees.bt;

import java.util.LinkedList;
import com.learning.dsa.trees.TreeNode;

public class ZigZagLevelOrderTraversal {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.createBinaryTree(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 });
		BinaryTree.levelOrderTraversal(tree.root);
		zigZagLevelOrderTraversal(tree.root);

	}

	static void zigZagLevelOrderTraversal(TreeNode root) {
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int level = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			if (level % 2 == 0) {
				for (int i = queue.size() - 1; i >= 0; i--) {
					System.out.print(queue.get(i).data + " ");
				}
			}
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (node != null) {
					if (level % 2 == 1) {
						System.out.print(node.data + " ");
					}
					if (node.left != null) {
						queue.offer(node.left);
					}
					if (node.right != null) {
						queue.offer(node.right);
					}
				}
			}
			level++;
			System.out.println();
		}
	}

}
