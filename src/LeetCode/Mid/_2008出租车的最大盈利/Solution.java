package LeetCode.Mid._2008出租车的最大盈利;

import java.util.Arrays;

/**
 * ClassName: Solution
 * Description: 出租车的最大盈利
 * Author Inamikanju
 * Create 2023/12/8 13:22
 * Version 1.0
 */
public class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        int idx = 0, m = rides.length;
        long[] dp = new long[n + 1];
        int[] head = new int[n + 1], next = new int[m];
        int[] edge = new int[m], weight = new int[m];
        Arrays.fill(head, -1);
        Arrays.fill(dp, -1);
        dp[n] = 0;
        for (int[] ride : rides) {
            next[idx] = head[ride[0]];
            head[ride[0]] = idx;
            edge[idx] = ride[1];
            weight[idx++] = ride[2];
        }

        for (int i = n - 1, j; i >= 0; i--) {
            for (dp[i] = dp[i + 1], j = head[i]; j >= 0; j = next[j]) {
                dp[i] = Math.max(dp[i], dp[edge[j]] + edge[j] - i + weight[j]);
            }
        }
        return dp[0];
    }
}
