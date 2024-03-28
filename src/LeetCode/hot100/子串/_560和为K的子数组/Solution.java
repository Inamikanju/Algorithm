package LeetCode.hot100.子串._560和为K的子数组;

/**
 * ClassName: Solution
 * Description: 和为 K 的子数组
 * Author Inamikanju
 * Create 2024/2/29 15:31
 * Version 1.0
 */
public class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum += nums[j];
                if (sum == k) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
