package com.learning.dsa.trees.bt;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

import com.learning.dsa.trees.TreeNode;

public class ZigZagLevelOrderTraversal {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.createBinaryTree(new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15});
		tree.levelOrderTraversal(tree.root);
		zigZagLevelOrderTraversal(tree.root);

	}
	
	static void zigZagLevelOrderTraversal(TreeNode root) {
		System.out.println("\n ZigZag Level Order Traversal");
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int level = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			if (queue.stream().filter(Objects::nonNull).count() > 0) {
				System.out.print("\nLevel " + level + " :");
			}
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (level % 2 == 1) {
					stack.add(node);
				}
				if (node != null) {
					if (level % 2 == 0) {
						System.out.print(node.data + " ");
					}
					queue.offer(node.left);
					queue.offer(node.right);
				}
			}
			if (level % 2 == 1) {
				while(!stack.isEmpty()) {
					System.out.print(stack.pop()+" ");
				}
				stack.clear();
			}
			level++;
		}
	}

}
