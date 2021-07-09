package com.learning.dsa.trees.bt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.learning.dsa.trees.TreeNode;

public class PrintCousins {

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.createBinaryTree(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 });
		BinaryTree.levelOrderTraversal(bt.root);
		System.out.println();
		printAllCousins(bt.root, 13);

	}

	static void printAllCousins(TreeNode root, int cousinData) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		List<Integer> notToPrint = new ArrayList<Integer>();
		while (!queue.isEmpty()) {
			int size = queue.size();
			if (!notToPrint.isEmpty()) {
				for (TreeNode node : queue) {
					if (!notToPrint.contains(node.data)) {
						System.out.print(node.data + " ");
					}
				}
				notToPrint.clear();
			}
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
				if (node.left != null && node.left.data == cousinData) {
					notToPrint.add(node.left.data);
					if (node.right != null) {
						notToPrint.add(node.right.data);
					}
				}
				if (node.right != null && node.right.data == cousinData) {
					notToPrint.add(node.right.data);
					if (node.left != null) {
						notToPrint.add(node.left.data);
					}
				}
			}
		}
	}
}
