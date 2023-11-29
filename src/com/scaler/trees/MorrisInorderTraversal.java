package com.scaler.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MorrisInorderTraversal {
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
        System.out.println(Arrays.toString(morrisInorderTraversal(one)));
        TreeUtils.inorder(one);
    }

    public static int[] morrisInorderTraversal(TreeNode A){
        List<Integer> resultList = new ArrayList<>();
        TreeNode current, pre;

        if (A == null) {
            return new int[]{};
        }
        current = A;
        while (current != null)
        {
            if (current.left == null)
            {
                resultList.add(current.val);
                current = current.right;
            }
            else {
                /* Find the inorder
                    predecessor of current
                 */
                pre = current.left;
                while (pre.right != null
                        && pre.right != current)
                    pre = pre.right;

                /* Make current as right
                   child of its
                 * inorder predecessor */
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                }

                /* Revert the changes made
                   in the 'if' part
                   to restore the original
                   tree i.e., fix
                   the right child of predecessor*/
                else
                {
                    pre.right = null;
                    resultList.add(current.val);
                    current = current.right;
                } /* End of if condition pre->right == NULL
                 */

            } /* End of if condition current->left == NULL*/

        } /* End of while */
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }
}
