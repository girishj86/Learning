package com.learning.dsa.trees.bt;

import java.util.ArrayList;
import java.util.List;

import com.learning.dsa.trees.TreeNode;

public class BranchSum {

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.createBinaryTree(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		BinaryTree.levelOrderTraversal(bt.root);
		System.out.println();
		branchSums(bt.root).stream().forEach(System.out::println);
		System.out.println(branchTargetSum(bt.root, 10));
	}

	public static List<Integer> branchSums(TreeNode root) {
		List<Integer> sums = new ArrayList<Integer>();
		calculateBranchSums(0, sums, root);
		return sums;
	}

	private static void calculateBranchSums(int sum, List<Integer> sums, TreeNode node) {
		if (node == null)
			return;
		sum = sum + node.data;
		if (node.left == null && node.right == null) {
			sums.add(sum);
			return;
		}
		calculateBranchSums(sum, sums, node.left);
		calculateBranchSums(sum, sums, node.right);
	}

	public static boolean branchTargetSum(TreeNode root, long targetSum) {
		return compareTargetBranchSum(0, targetSum, root);
	}

	private static boolean compareTargetBranchSum(long branchSum, long targetSum, TreeNode node) {
		if (node == null) {
			return false;
		}
		branchSum = branchSum + node.data;
		if (node.left == null && node.right == null) {
			return branchSum == targetSum;
		}
		return compareTargetBranchSum(branchSum, targetSum, node.left)
				|| compareTargetBranchSum(branchSum, targetSum, node.right);
	}

}
