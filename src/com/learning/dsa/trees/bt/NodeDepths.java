package com.learning.dsa.trees.bt;

import java.util.LinkedList;
import java.util.Queue;

import com.learning.dsa.trees.TreeNode;

public class NodeDepths {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.createBinaryTree(new int[] { 1, 2, 3, 4, 5, 6, 7 });
		System.out.println(nodeDepths(tree.root));

	}

	static long nodeDepths(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int level = 0;
		long sum = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				sum = sum + level;
				TreeNode node = queue.poll();
				if (node != null) {
					if (node.left != null) {
						queue.offer(node.left);
					}
					if (node.right != null) {
						queue.offer(node.right);
					}
				}
			}
			level++;
		}
		return sum;
	}

}
