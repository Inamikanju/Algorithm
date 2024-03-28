package LeetCode.hot100.动态规划._118杨辉三角;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Solution
 * Description: 杨辉三角
 * Author Inamikanju
 * Create 2024/3/8 15:55
 * Version 1.0
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    list.add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
                }
            }
            ans.add(list);
        }
        return ans;
    }
}
