package com.learning.dsa.trees.bt;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

import com.learning.dsa.trees.TreeNode;

public class BinaryTree {

	TreeNode root;

	public BinaryTree(int data) {
		this.root = new TreeNode(data);
	}

	public BinaryTree() {
	}

	void createBinaryTree(int[] elements) {
		for (int el : elements) {
			levelOrderInsert(el);
		}
	}

	/* Function to insert data recursively */
	void levelOrderInsert(int data) {
		if (root == null) {
			root = new TreeNode(data);
			return;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (true) {
			int size = queue.size();
			TreeNode node = queue.poll();
			for (int i = 0; i < size; i++) {
				if (node.left == null) {
					node.left = new TreeNode(data);
					return;
				}
				if (node.right == null) {
					node.right = new TreeNode(data);
					return;
				}
				queue.offer(node.left);
				queue.offer(node.right);
			}
		}
	}

	void inorder(TreeNode root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}

	void preorder(TreeNode root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preorder(root.left);
			preorder(root.right);
		}
	}

	void postorder(TreeNode root) {
		if (root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.data + " ");
		}
	}

	static void levelOrderTraversal(TreeNode root) {
		System.out.println("Level Order Traversal");
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int level = 1;
		while (!queue.isEmpty()) {
			System.out.print("\nLevel "+level+" : ");
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (node != null) {
					System.out.print(node.data + " ");
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
		System.out.println();
	}

	public void inorderIterative(TreeNode root) {
		Stack<TreeNode> stack = new Stack();
		TreeNode curr = root;
		while (!stack.empty() || curr != null) {
			if (curr != null) {
				stack.push(curr);
				curr = curr.left;
			} else {
				curr = stack.pop();
				System.out.print(curr.data + " ");

				curr = curr.right;
			}
		}
	}

	static int height(TreeNode node) {
		if (node == null)
			return 0;
		return (1 + Math.max(height(node.left), height(node.right)));
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.createBinaryTree(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 });
		System.out.println(BinaryTree.height(tree.root));
		tree.inorderIterative(tree.root);
	}
}
