package com.learning.dsa.trees.bt;

import java.util.LinkedList;
import com.learning.dsa.trees.TreeNode;

public class PrintAllPaths {

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.createBinaryTree(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		BinaryTree.levelOrderTraversal(bt.root);
		printAllPaths(bt.root);

	}
	
	public static void printAllPaths(TreeNode root) {
		printPaths(new LinkedList<Integer>(), root);
	}

	private static void printPaths(LinkedList<Integer> paths, TreeNode node) {
		if(node == null) {
			return;
		}
		paths.add(node.data);
		if(node.left == null && node.right == null) {
			System.out.println(paths);
		}
		printPaths(paths, node.left);
		printPaths(paths, node.right);
		paths.removeLast();
	}
}
