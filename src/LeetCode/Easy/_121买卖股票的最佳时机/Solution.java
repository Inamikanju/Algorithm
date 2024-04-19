package LeetCode.Easy._121买卖股票的最佳时机;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Solution
 * Description:
 * Author Inamikanju
 * Create 2024/4/19 0:14
 * Version 1.0
 */
public class Solution {
    public int maxProfit(int[] prices) {
        // 遍历一遍，取最小的买入，算最大利润
        int n = prices.length;
        int ans = 0;
        int min = 0x3f3f3f3f;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, prices[i]);
            ans = Math.max(ans, prices[i] - min);
        }
        return ans;
    }

    public int[] maxProfitInterval(int[] prices){
        // 遍历一遍，取最小的买入，算最大利润
        int n = prices.length;
        int ans = 0;
        int min = 0x3f3f3f3f;
        int minIdx = 0;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(min>=prices[i]){
                min = prices[i];
                minIdx=i;
            }
            int profit = prices[i]-min;
            if(ans==profit){
                list.add(new int[]{minIdx,i});
            }else if(ans<profit){
                list=new ArrayList<>();
                list.add(new int[]{minIdx,i});
            }
        }
        return list.get(0);
    }
}
