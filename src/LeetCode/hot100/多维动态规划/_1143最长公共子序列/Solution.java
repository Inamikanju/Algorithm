package LeetCode.hot100.多维动态规划._1143最长公共子序列;

/**
 * ClassName: Solution
 * Description: 最长公共子序列
 * Author Inamikanju
 * Create 2024/3/20 21:42
 * Version 1.0
 */
public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length();
        int l2 = text2.length();
        // 表示text1[0,i]和text2[0,j]的最长公共子序列的长度
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 1; i <= l1; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= l2; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[l1][l2];
    }
}
