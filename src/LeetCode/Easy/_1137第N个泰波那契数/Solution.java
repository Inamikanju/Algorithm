package LeetCode.Easy._1137第N个泰波那契数;

/**
 * ClassName: Solution
 * Description: 第 N 个泰波那契数
 * Author Inamikanju
 * Create 2023/12/10 12:31
 * Version 1.0
 */
public class Solution {
    public int tribonacci(int n) {
        if (n <= 1) {
            return n;
        }
        if (n == 2) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;

        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }

        return dp[n];
    }
}
