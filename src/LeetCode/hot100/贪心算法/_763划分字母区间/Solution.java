package LeetCode.hot100.贪心算法._763划分字母区间;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Solution
 * Description: 划分字母区间
 * Author Inamikanju
 * Create 2024/3/13 17:02
 * Version 1.0
 */
public class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        int length = s.length();
        for (int i = 0; i < length; i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> ans = new ArrayList<>();
        int left = 0;
        int right = 0;
        for (int i = 0; i < length; i++) {
            right = Math.max(right, last[s.charAt(i) - 'a']);
            if (i == right) {
                ans.add(right - left + 1);
                left = right + 1;
            }
        }
        return ans;
    }
}
