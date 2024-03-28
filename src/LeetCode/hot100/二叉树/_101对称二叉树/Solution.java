package LeetCode.hot100.二叉树._101对称二叉树;

import DataStructure.TreeNode;

/**
 * ClassName: Solution
 * Description: 对称二叉树
 * Author Inamikanju
 * Create 2024/3/3 16:57
 * Version 1.0
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return check(p.left, q.right) && check(p.right, q.left);
    }
}
