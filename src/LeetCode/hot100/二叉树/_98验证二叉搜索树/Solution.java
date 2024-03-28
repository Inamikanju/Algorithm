package LeetCode.hot100.二叉树._98验证二叉搜索树;

import DataStructure.TreeNode;

/**
 * ClassName: Solution
 * Description: 验证二叉搜索树
 * Author Inamikanju
 * Create 2024/3/8 15:41
 * Version 1.0
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}
