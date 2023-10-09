package com.scaler.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RightView {
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
        System.out.println(rightView(one));
    }

    public static ArrayList<Integer> rightView(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        while(!queue.isEmpty()){
            int qSize = queue.size();
            LinkedList<TreeNode> level = new LinkedList<>();
            for(int i=0;i<qSize;i++) {
                TreeNode tmp = queue.poll();
                level.add(tmp);
                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
            }
            result.add(level.getLast().val);
        }
        return result;
    }
}
