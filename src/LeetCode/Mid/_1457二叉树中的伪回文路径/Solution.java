package LeetCode.Mid._1457二叉树中的伪回文路径;

import DataStructure.TreeNode;

/**
 * ClassName: Solution
 * Description: 二叉树中的伪回文路径
 * Author Inamikanju
 * Create 2023/11/25 20:12
 * Version 1.0
 */
public class Solution {
    public int pseudoPalindromicPaths(TreeNode root) {
        int[] count = new int[10];
        return dfs(root, count);
    }

    private int dfs(TreeNode root, int[] count) {
        if (root == null) {
            return 0;
        }
        count[root.val]++;
        int ans = 0;
        if (root.left == null && root.right == null) {
            if (isOdd(count)) {
                ans = 1;
            }
        } else {
            ans = dfs(root.left, count) + dfs(root.right, count);
        }
        count[root.val]--;
        return ans;
    }

    private boolean isOdd(int[] count) {
        int odd = 0;
        for (int cnt : count) {
            if (cnt % 2 == 1) {
                odd++;
            }
        }
        return odd <= 1;
    }
}
