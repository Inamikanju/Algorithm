package LeetCode.hot100.动态规划._279完全平方数;

/**
 * ClassName: Solution
 * Description: 完全平方数
 * Author Inamikanju
 * Create 2024/3/12 15:00
 * Version 1.0
 */
public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
