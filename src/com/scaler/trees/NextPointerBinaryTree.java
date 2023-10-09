package com.scaler.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NextPointerBinaryTree {
    public static void main(String[] args) {
        TreeLinkNode one = new TreeLinkNode(1);
        TreeLinkNode two = new TreeLinkNode(2);
        TreeLinkNode three = new TreeLinkNode(3);
        TreeLinkNode four = new TreeLinkNode(4);
        TreeLinkNode five = new TreeLinkNode(5);
        TreeLinkNode six = new TreeLinkNode(6);
        TreeLinkNode seven = new TreeLinkNode(7);
        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        three.left = six;
        three.right = seven;
        connect(one);
    }

    public static void connect(TreeLinkNode root) {
        List<ArrayList<TreeLinkNode>> allLevels = new ArrayList<>();
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            ArrayList<TreeLinkNode> level = new ArrayList<>();
            for (int i = 0; i < qSize; i++) {
                TreeLinkNode tmp = queue.poll();
                level.add(tmp);
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }
            allLevels.add(level);
        }
        for (ArrayList<TreeLinkNode> level : allLevels) {
            for (int i = 0; i < level.size() - 1; i++) {
                level.get(i).next = level.get(i + 1);
            }
        }
    }
}

