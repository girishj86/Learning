package com.scaler.trees;

public class LCA {
    public static void main(String[] args) {
        TreeNode root = TreeUtils.createSampleTree();
        TreeUtils.printLevelOrderTraversal(root);
        System.out.println(lca(root,4,5));
    }

    public static int lca(TreeNode A, int B, int C) {
        if(!checkNodeExists(A,B) || !checkNodeExists(A,C)){
            return -1;
        }
        TreeNode lca = findLCA(A,B,C);
        if(lca != null) return lca.val;
        return -1;
    }

    private static TreeNode findLCA(TreeNode node, int B, int C)
    {
        if (node == null) {
            return null;
        }

        if (node.val == B || node.val == C) {
            return node;
        }

        TreeNode left_lca = findLCA(node.left, B, C);
        TreeNode right_lca = findLCA(node.right, B, C);

        if (left_lca != null && right_lca != null) {
            return node;
        }

        return (left_lca != null) ? left_lca : right_lca;
    }

    private static boolean checkNodeExists(TreeNode A, int val) {
        if (A == null) {
            return false;
        }

        if (A.val == val) {
            return true;
        }

        return checkNodeExists(A.left, val) || checkNodeExists(A.right, val);
    }

}
