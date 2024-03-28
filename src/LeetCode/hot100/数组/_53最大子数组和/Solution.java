package LeetCode.hot100.数组._53最大子数组和;

/**
 * ClassName: Solution
 * Description: 最大子数组和
 * Author Inamikanju
 * Create 2024/3/4 23:22
 * Version 1.0
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int dp = 0;
        for (int num : nums) {
            dp = Math.max(dp+num,num);
            ans = Math.max(dp,ans);
        }
        return ans;
    }
}
