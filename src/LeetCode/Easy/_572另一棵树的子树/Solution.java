package LeetCode.Easy._572另一棵树的子树;

import DataStructure.TreeNode;

/**
 * ClassName: Solution
 * Description: 另一棵树的子树
 * Author Inamikanju
 * Create 2024/4/10 15:16
 * Version 1.0
 */
public class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //递归出口
        if (root == null) return false;
        //前序遍历
        boolean parent = false;
        if (root.val == subRoot.val) {
            parent = compare(root, subRoot);
        }
        boolean left = isSubtree(root.left, subRoot);
        boolean right = isSubtree(root.right, subRoot);
        return parent || left || right;
    }

    private boolean compare(TreeNode root, TreeNode subRoot) {
        //递归出口
        if (root == null && subRoot == null) return true;
        if (root == null) return false;
        if (subRoot == null) return false;
        if (root.val != subRoot.val) return false;
        //后序遍历
        return compare(root.left, subRoot.left) && compare(root.right, subRoot.right);
    }
}
