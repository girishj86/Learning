package com.learning.dsa.trees.bt;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

import com.learning.dsa.trees.TreeNode;

public class MaximumWidth {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.createBinaryTree(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9});
		System.out.println(getMaxWidth(tree.root));
	}

	static long getMaxWidth(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		long maxWidth = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			maxWidth = Math.max(queue.stream().filter(Objects::nonNull).count(), maxWidth);
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (node != null) {
					System.out.print(node.data + " ");
					queue.offer(node.left);
					queue.offer(node.right);
				}
			}
			System.out.println();
		}
		return maxWidth;
	}
}
