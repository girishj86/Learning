package com.learning.dsa.trees.bst;

import java.util.ArrayList;
import java.util.List;

import com.learning.dsa.trees.TreeNode;

public class BranchSum {

	public static void main(String[] args) {
		TreeNode root = BinarySearchTree.getBinarySearchTree(new int[] {1,2,3,4,5,6,7});
	}
	
	public static List<Integer> getBranchSum(TreeNode root){
		List<Integer> branchSum = new ArrayList<Integer>();
		int runningSum = 0;
		calculateBranchSum(root, runningSum, branchSum);
		return branchSum;
	}

	private static void calculateBranchSum(TreeNode node, int runningSum, List<Integer> branchSum) {
		if(node.left == null && node.right == null) {
			branchSum.add(runningSum + node.data);
			return;
		}
		calculateBranchSum(node.left, runningSum, branchSum);
		calculateBranchSum(node.right, runningSum, branchSum);
	}

}
