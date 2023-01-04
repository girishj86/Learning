package com.learning.dsa.trees.bst;

import com.learning.dsa.trees.TreeNode;

import java.util.*;

public class CreateBSTFromArray {
    public static void main(String[] args) {
        int[] arr = {7,8,6,1,2,3,9,4,5,10,11,12,13,14,15,16,17};
        Arrays.sort(arr);
        TreeNode root = createBSTFromArray(arr,0,arr.length-1);
        BinarySearchTree.printLevelOrder(root);
    }

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


}


