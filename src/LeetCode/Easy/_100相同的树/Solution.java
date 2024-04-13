package LeetCode.Easy._100相同的树;

import DataStructure.TreeNode;

/**
 * ClassName: Solution
 * Description: 相同的树
 * Author Inamikanju
 * Create 2024/4/10 15:10
 * Version 1.0
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //递归出口
        if (p == null && q == null) return true;
        if (p == null) return false;
        if (q == null) return false;
        if (p.val != q.val) return false;
        //后序遍历
        boolean left = isSameTree(p.left, q.left);
        boolean right = isSameTree(p.right, q.right);
        boolean pt = left && right;
        return pt;
    }
}
