package LeetCode.hot100.二叉树._543二叉树的直径;

import DataStructure.TreeNode;

/**
 * ClassName: Solution
 * Description: 二叉树的直径
 * Author Inamikanju
 * Create 2024/3/8 14:49
 * Version 1.0
 */
public class Solution {
    private int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        //每个结点的最大值是L+R+1，但是向上传递的值是Max(L,R)+1
        depth(root);
        return ans;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        ans = Math.max(ans, left + right);
        return Math.max(left, right)+1;
    }
}
