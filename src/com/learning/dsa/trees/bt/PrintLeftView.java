package com.learning.dsa.trees.bt;

import java.util.LinkedList;
import com.learning.dsa.trees.TreeNode;

public class PrintLeftView {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.createBinaryTree(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
//		printLeftView(tree.root);
//		printRightView(tree.root);
		TreeNode root = new TreeNode(1);
//		root.right = new TreeNode(2);
//		root.right.left = new TreeNode(3);
//		root.right.left.right = new TreeNode(4);
//		printLeftView(root);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		root.right.left.left = new TreeNode(6);
		printLeftView(root);
		printRightView(root);
	}

	public static void printLeftView(TreeNode root) {
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			System.out.println(queue.getFirst().data);
			for (int i = 0; i < size; i++) {
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
		}
	}

	public static void printRightView(TreeNode root) {
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			System.out.println(queue.getLast().data);
			for (int i = 0; i < size; i++) {
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
		}
	}
}
