package Tools.Knapsack;

/**
 * ClassName: Knapsack
 * Description:
 * Author Inamikanju
 * Create 2023/11/15 17:26
 * Version 1.0
 */
public class Knapsack {
    public static void main(String[] args) {
        int[] weights = {2, 2, 6, 5, 4};
        int[] values = {6, 3, 5, 4, 6};
        int capacity = 10;

        int maxValue = knapsack(weights, values, capacity);
        System.out.println("最大价值: " + maxValue);
    }

    private static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][capacity];
    }
}
