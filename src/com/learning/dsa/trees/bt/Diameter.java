package com.learning.dsa.trees.bt;

import com.learning.dsa.trees.TreeNode;

public class Diameter {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.createBinaryTree(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 });
		System.out.println(diameter(tree.root));

	}
	
	static int diameter(TreeNode root)
    {
        // base case if tree is empty
        if (root == null)
            return 0;

        // get the height of left and right sub-trees
        int lheight = BinaryTree.height(root.left);
        int rheight = BinaryTree.height(root.right);

        // get the diameter of left and right sub-trees
        int ldiameter = diameter(root.left);
        int rdiameter = diameter(root.right);

        /* Return max of following three
          1) Diameter of left subtree
          2) Diameter of right subtree
          3) Height of left subtree + height of right subtree + 1
         */
        return Math.max(lheight + rheight + 1,
                        Math.max(ldiameter, rdiameter));
    }


}
