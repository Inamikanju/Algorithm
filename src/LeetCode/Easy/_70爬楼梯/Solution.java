package LeetCode.Easy._70爬楼梯;

/**
 * ClassName: Solution
 * Description: 爬楼梯
 * Author Inamikanju
 * Create 2023/12/10 12:26
 * Version 1.0
 */
public class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }
}
