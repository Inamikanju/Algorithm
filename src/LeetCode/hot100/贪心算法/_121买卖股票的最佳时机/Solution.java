package LeetCode.hot100.贪心算法._121买卖股票的最佳时机;

/**
 * ClassName: Solution
 * Description: 买卖股票的最佳时机
 * Author Inamikanju
 * Create 2024/3/13 15:45
 * Version 1.0
 */
public class Solution {
    public int maxProfit(int[] prices) {
        //遍历一次，取最小的买入，保存当前最大利润
        int ans = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            ans = Math.max(ans, prices[i] - minPrice);
        }
        return ans;
    }
}
