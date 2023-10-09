package com.scaler.trees;

import java.util.LinkedList;
import java.util.Queue;

public class TreeUtils {
    public static TreeNode createBSTFromArray(int[] arr, int start, int end){
        if(start>end) {
            return null;
        }
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = createBSTFromArray(arr,start,mid-1);
        root.right = createBSTFromArray(arr, mid+1, end);
        return root;
    }

    public static void printLevelOrderTraversal(TreeNode root){
        System.out.println("Level Order Traversal");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;
        while (!queue.isEmpty()) {
            System.out.print("\nLevel "+level+" : ");
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    System.out.print(node.val + " ");
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            level++;
        }
        System.out.println();
    }

    private static boolean search(TreeNode root, int num){
        if(root == null) return false;
        if(root.val == num) return true;
        if(num < root.val) {
            return search(root.left, num);
        } else {
            return search(root.right, num);
        }
    }
}
