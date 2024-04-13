package LeetCode.Easy._104二叉树的最大深度;

import DataStructure.TreeNode;

/**
 * ClassName: Solution
 * Description: 二叉树的最大深度
 * Author Inamikanju
 * Create 2024/4/10 15:41
 * Version 1.0
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        //递归出口
        if (root == null) {
            return 0;
        }
        //后序遍历
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        int prt = Math.max(left, right) + 1;
        return prt;
    }
}
