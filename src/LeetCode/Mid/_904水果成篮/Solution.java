package LeetCode.Mid._904水果成篮;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: Solution
 * Description: 水果成篮
 * Author Inamikanju
 * Create 2023/11/3 17:02
 * Version 1.0
 */
public class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int left = 0;
        int right = 0;
        int ans = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (; right < n; right++) {
            cnt.put(fruits[right], cnt.getOrDefault(fruits[right], 0) + 1);
            while (cnt.size() > 2) {
                cnt.put(fruits[left], cnt.get(fruits[left]) - 1);
                if (cnt.get(fruits[left]) == 0) {
                    cnt.remove(fruits[left]);
                }
                left++;
            }
            ans=Math.max(ans,right-left+1);
        }
        return ans;
    }
}
