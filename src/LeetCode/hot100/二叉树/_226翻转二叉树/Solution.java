package LeetCode.hot100.二叉树._226翻转二叉树;

import DataStructure.TreeNode;

/**
 * ClassName: Solution
 * Description: 翻转二叉树
 * Author Inamikanju
 * Create 2024/3/3 16:52
 * Version 1.0
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
