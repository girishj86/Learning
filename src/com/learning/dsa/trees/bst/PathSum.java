package com.learning.dsa.trees.bst;

import java.util.ArrayList;
import java.util.List;

import com.learning.dsa.trees.TreeNode;

public class PathSum {

	public static void main(String[] args) {
		TreeNode root = BinarySearchTree.getBinarySearchTree(new int[] {1,2,3,4,5,6,7});
		BinarySearchTree.printLevelOrder(root);
		getBranchSum(root).stream().forEach(System.out::println);
	}
	
	public static List<Integer> getBranchSum(TreeNode root){
		List<Integer> pathSum = new ArrayList<Integer>();
		int sum = 0;
		calculateBranchSum(root, sum, pathSum);
		return pathSum;
	}

	private static void calculateBranchSum(TreeNode node, int sum, List<Integer> pathSum) {
		if(node == null){
			return;
		}
		sum = sum +node.data;
		if(node.left == null && node.right == null) {
			pathSum.add(sum);
			return;
		}
		calculateBranchSum(node.left, sum, pathSum);
		calculateBranchSum(node.right, sum, pathSum);
	}

}
