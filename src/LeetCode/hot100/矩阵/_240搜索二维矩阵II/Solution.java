package LeetCode.hot100.矩阵._240搜索二维矩阵II;

/**
 * ClassName: Solution
 * Description: 搜索二维矩阵 II
 * Author Inamikanju
 * Create 2024/3/17 15:38
 * Version 1.0
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] row : matrix) {
            if (search(row, target)) {
                return true;
            }
        }
        return false;
    }

    private boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int num = nums[mid];
            if (num == target) {
                return true;
            } else if (num > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
