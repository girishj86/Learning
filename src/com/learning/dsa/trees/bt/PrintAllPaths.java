package com.learning.dsa.trees.bt;

import com.learning.dsa.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PrintAllPaths {

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.createBinaryTree(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        BinaryTree.levelOrderTraversal(bt.root);
        List<LinkedList<Integer>> allPathsFromRoot = new ArrayList<>();
        getAllPaths(bt.root, allPathsFromRoot);
        allPathsFromRoot.forEach(System.out::println);
    }

    public static void getAllPaths(TreeNode root, List<LinkedList<Integer>> allPathsFromRoot) {
    	getPaths(root, new LinkedList<>(), allPathsFromRoot);
    }

    private static void getPaths(TreeNode node, LinkedList<Integer> currentPath, List<LinkedList<Integer>> allPathsFromRoot) {
        if (node == null) {
            return;
        }
        currentPath.add(node.data);
        if (node.left == null && node.right == null) {
            allPathsFromRoot.add(new LinkedList<>(currentPath));
        }
        getPaths(node.left, currentPath, allPathsFromRoot);
        getPaths(node.right, currentPath, allPathsFromRoot);
        currentPath.removeLast();
    }
}
