package LeetCode.Easy._101对称二叉树;

import DataStructure.TreeNode;

/**
 * ClassName: Solution
 * Description: 对称二叉树
 * Author Inamikanju
 * Create 2024/4/10 14:51
 * Version 1.0
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        //递归出口
        if (left == null && right == null) return true;
        if (left == null) return false;
        if (right == null) return false;
        if (left.val != right.val) return false;
        //后序遍历
        boolean out = compare(left.left, right.right);
        boolean in = compare(left.right, right.left);
        boolean p = out && in;
        return p;
    }
}
