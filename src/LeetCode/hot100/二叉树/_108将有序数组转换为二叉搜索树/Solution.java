package LeetCode.hot100.二叉树._108将有序数组转换为二叉搜索树;

import DataStructure.TreeNode;

/**
 * ClassName: Solution
 * Description: 将有序数组转换为二叉搜索树
 * Author Inamikanju
 * Create 2024/3/8 15:34
 * Version 1.0
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, left, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, right);
        return node;
    }
}
