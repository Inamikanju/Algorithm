package LeetCode.Easy._938二叉搜索树的范围和;

import DataStructure.TreeNode;

/**
 * ClassName: Solution
 * Description: 二叉搜索树的范围和
 * Author Inamikanju
 * Create 2024/2/26 17:27
 * Version 1.0
 */
public class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}
