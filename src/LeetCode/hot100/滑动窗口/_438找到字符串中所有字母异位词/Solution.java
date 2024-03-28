package LeetCode.hot100.滑动窗口._438找到字符串中所有字母异位词;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: Solution
 * Description: 找到字符串中所有字母异位词
 * Author Inamikanju
 * Create 2024/2/29 11:39
 * Version 1.0
 */
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() < p.length()) {
            return ans;
        }
        int[] pCount = new int[26];
        int[] sCount = new int[26];
        int left = 0;
        int right = 0;
        for (; right < p.length(); right++) {
            pCount[p.charAt(right) - 'a']++;
            sCount[s.charAt(right) - 'a']++;
        }
        if (Arrays.equals(pCount, sCount)) {
            ans.add(left);
        }
        for (; right < s.length(); right++) {
            sCount[s.charAt(right) - 'a']++;
            sCount[s.charAt(left) - 'a']--;
            if (Arrays.equals(pCount, sCount)) {
                ans.add(left + 1);
            }
            left++;
        }
        return ans;
    }
}
