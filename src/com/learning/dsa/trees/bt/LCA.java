package com.learning.dsa.trees.bt;

import com.learning.dsa.trees.TreeNode;

public class LCA {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.createBinaryTree(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 });
		System.out.println(findLCA(tree.root, 4, 12).data);

	}

	static TreeNode findLCA(TreeNode node, int n1, int n2) {
		// Base case
		if (node == null)
			return null;

		// If either n1 or n2 matches with root's key, report
		// the presence by returning root (Note that if a key is
		// ancestor of other, then the ancestor key becomes LCA
		if (node.data == n1 || node.data == n2)
			return node;

		// Look for keys in left and right subtrees
		TreeNode leftLCA = findLCA(node.left, n1, n2);
		TreeNode rightLCA = findLCA(node.right, n1, n2);

		// If both of the above calls return Non-NULL, then one key
		// is present in once subtree and other is present in other,
		// So this TreeNode is the LCA
		if (leftLCA != null && rightLCA != null)
			return node;

		// Otherwise check if left subtree or right subtree is LCA
		return (leftLCA != null) ? leftLCA : rightLCA;
	}

}
