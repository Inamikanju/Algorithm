package LeetCode.hot100.二分查找._34在排序数组中查找元素的第一个和最后一个位置;

/**
 * ClassName: Solution
 * Description: 在排序数组中查找元素的第一个和最后一个位置
 * Author Inamikanju
 * Create 2024/3/25 18:28
 * Version 1.0
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = binarySearchLeft(nums, target);
        int right = binarySearchRight(nums, target);
        if (left <= right) {
            return new int[]{left, right};
        }
        return new int[]{-1, -1};
    }

    private int binarySearchLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right + 1;
    }

    private int binarySearchRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1;
    }

}
