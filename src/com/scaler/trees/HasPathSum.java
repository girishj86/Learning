package com.scaler.trees;

public class HasPathSum {

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        one.left = two; one.right = three;
        two.left = four; two.right = five;
        three.left = six; three.right = seven;
        System.out.println(hasPathSum(one,88));
    }
    public static boolean hasPathSum(TreeNode node, int subSum){
        if(node == null) return false;
        subSum = subSum - node.val;
        if(node.left == null && node.right==null && subSum == 0){
            return true;
        }
        if(hasPathSum(node.left, subSum) || hasPathSum(node.right, subSum)){
            return true;
        }
        return false;
    }
}
