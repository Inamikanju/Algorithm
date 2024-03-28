package LeetCode.Easy._509斐波那契数;

/**
 * ClassName: Solution
 * Description: 斐波那契数
 * Author Inamikanju
 * Create 2023/12/10 12:29
 * Version 1.0
 */
public class Solution {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
