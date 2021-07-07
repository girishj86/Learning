package com.learning.dsa.trees.bst;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import com.learning.dsa.trees.TreeNode;

public class BinarySearchTree {

	public static TreeNode getBinarySearchTree(int[] array) {
		Arrays.parallelSort(array);
		return createBST(0, array.length - 1, array);
	}

	private static TreeNode createBST(int start, int end, int[] array) {
		if (start > end) {
			return null;
		}
		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(array[mid]);
		root.left = createBST(start, mid-1, array);
		root.right = createBST(mid + 1, end, array);
		return root;
	}

	public static void printLevelOrder(TreeNode root) {
		if (root == null)
			return;

		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);

		while (true) {
			int nodeCount = q.size();
			if (nodeCount == 0)
				break;
			while (nodeCount > 0) {
				TreeNode node = q.peek();
				System.out.print(node.data + " ");
				q.remove();
				if (node.left != null)
					q.add(node.left);
				if (node.right != null)
					q.add(node.right);
				nodeCount--;
			}
			System.out.println();
		}
	}
}
