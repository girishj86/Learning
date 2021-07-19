package com.learning.dsa.trees.bt;

import com.learning.dsa.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class PathFromRootToNode {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.createBinaryTree(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        LinkedList<Integer> path = new LinkedList<>();

        if (hasPath(bt.root, path, 8)) {
            System.out.println(path);
        }
    }

    public static boolean hasPath(TreeNode node, LinkedList<Integer> path, int nodeData) {
        if (node == null) {
            return false;
        }
        path.add(node.data);
        if (node.data == nodeData) {
            return true;
        }
        boolean hasPathInLeft = hasPath(node.left, path, nodeData);
        boolean hasPathInRight = hasPath(node.right, path, nodeData);
        if (hasPathInLeft || hasPathInRight) {
            return true;
        }
        path.removeLast();
        return false;
    }

}

