package com.learning.dsa.trees.bt;

import java.util.ArrayList;
import java.util.List;

import com.learning.dsa.trees.TreeNode;

public class BranchSum {

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.createBinaryTree(new int[] { 2, 3, 4, 5, 6, 7, 8, 9 });
		bt.levelOrderTraversal(bt.root);
		System.out.println();
		branchSums(bt.root).stream().forEach(System.out::println);
	}
	
	public static List<Integer> branchSums(TreeNode root) {
		List<Integer> sums = new ArrayList<Integer>();
		calculateBranchSums(0, sums, root);
		return sums;
	}

	private static void calculateBranchSums(int sum, List<Integer> sums, TreeNode node) {
		if(node == null) return;
		sum = sum + node.data;
		if (node.left == null && node.right == null) {
			sums.add(sum);
			return;
		}
		calculateBranchSums(sum, sums, node.left);
		calculateBranchSums(sum, sums, node.right);

	}
}
