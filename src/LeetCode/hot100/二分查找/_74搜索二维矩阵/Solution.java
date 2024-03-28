package LeetCode.hot100.二分查找._74搜索二维矩阵;

/**
 * ClassName: Solution
 * Description: 搜索二维矩阵
 * Author Inamikanju
 * Create 2024/3/24 15:27
 * Version 1.0
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        int left = 0;
        int right = m - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (right < 0) {
            return false;
        }
        int row = right;
        left = 0;
        right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
