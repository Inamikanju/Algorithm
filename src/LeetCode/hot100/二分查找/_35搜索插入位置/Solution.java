package LeetCode.hot100.二分查找._35搜索插入位置;

/**
 * ClassName: Solution
 * Description: 搜索插入位置
 * Author Inamikanju
 * Create 2024/3/24 15:09
 * Version 1.0
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
        //left是大于target的左边界
        //right是小于target的右边界
    }
}
