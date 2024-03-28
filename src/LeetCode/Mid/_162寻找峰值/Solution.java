package LeetCode.Mid._162寻找峰值;


/**
 * ClassName: Solution
 * Description: 寻找峰值
 * Author Inamikanju
 * Create 2023/12/18 15:34
 * Version 1.0
 */
public class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
