package com.scaler.trees;

public class ValidBST {
    public static void main(String[] args) {
        int[] arr = {4, 8, 12, 15, 19, 23, 27};
        TreeNode A = TreeUtils.createBSTFromArray(arr, 0, arr.length - 1);
        TreeUtils.printLevelOrderTraversal(A);
        System.out.println("---");
        System.out.println(isValidBST(A));
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
        System.out.println(isValidBST(one));
    }

    private static int isValidBST(TreeNode A) {
        return isValidBST(A, Integer.MIN_VALUE, Integer.MAX_VALUE) ? 1 : 0;
    }

    private static boolean isValidBST(TreeNode A, int rangeMin, int rangeMax) {
        if (A == null) return true;
        if (A.val < rangeMin || A.val > rangeMax) return false;

        boolean isLeftBSTValid = isValidBST(A.left, rangeMin, A.val - 1);
        boolean isRightBSTValid = isValidBST(A.right, A.val + 1, rangeMax);

        if (isLeftBSTValid && isRightBSTValid) {
            return true;
        }
        return false;
    }
}
