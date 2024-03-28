package LeetCode.hot100.二叉树._104二叉树的最大深度;

import DataStructure.TreeNode;

/**
 * ClassName: Solution
 * Description: 二叉树的最大深度
 * Author Inamikanju
 * Create 2024/3/3 16:48
 * Version 1.0
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
