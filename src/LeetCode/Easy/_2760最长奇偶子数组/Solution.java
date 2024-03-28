package LeetCode.Easy._2760最长奇偶子数组;

/**
 * ClassName: Solution
 * Description: 最长奇偶子数组
 * Author Inamikanju
 * Create 2023/11/17 11:47
 * Version 1.0
 */
public class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int ans = 0;
        int dp = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > threshold) {
                dp = 0;
            } else if (i == nums.length - 1 || nums[i] % 2 != nums[i + 1] % 2) {
                dp++;
            } else {
                dp = 1;
            }
            if (nums[i] % 2 == 0) {
                ans = Math.max(ans, dp);
            }
        }
        return ans;
    }
}
