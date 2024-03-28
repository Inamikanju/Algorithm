package LeetCode.Mid._2304网格中的最小路径代价;

import java.util.Arrays;

/**
 * ClassName: Solution
 * Description: 网格中的最小路径代价
 * Author Inamikanju
 * Create 2023/11/22 19:36
 * Version 1.0
 */
public class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;//行
        int n = grid[0].length;//列
        int[][] dp = new int[m][n];//从第1行到第i行j列的最小代价
        //dp[i][j]=min(0<=k<n)(dp[i-1][k]+moveCost[grid[i-1][k]][j]+grid[i][j])
        for (int j = 0; j < n; j++) {
            dp[0][j] = grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    dp[i][j] = Math.min((dp[i - 1][k] + moveCost[grid[i - 1][k]][j] + grid[i][j]), dp[i][j]);
                }
            }
        }
        return Arrays.stream(dp[m - 1]).min().getAsInt();
    }
}
