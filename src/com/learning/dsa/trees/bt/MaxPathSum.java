package com.learning.dsa.trees.bt;

import com.learning.dsa.trees.TreeNode;

public class MaxPathSum {

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.createBinaryTree(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 });
		BinaryTree.levelOrderTraversal(bt.root);
		System.out.println();
		System.out.println(maximumSum(bt.root));

	}

	public static Result maximumSum(TreeNode root) {
		Result result = new Result();
		calculateBranchSums(0, result, root);
		return result;
	}

	private static void calculateBranchSums(int sum, Result result, TreeNode node) {
		if (node == null)
			return;
		sum = sum + node.data;
		if (node.left == null && node.right == null) {
			if (sum > result.maximumSum) {
				result.maximumSum = sum;
			}
			return;
		}
		calculateBranchSums(sum, result, node.left);
		calculateBranchSums(sum, result, node.right);
	}
}

class Result {
	int maximumSum = Integer.MIN_VALUE;

	@Override
	public String toString() {
		return "Maximum Sum=" + maximumSum;
	}
	
}
