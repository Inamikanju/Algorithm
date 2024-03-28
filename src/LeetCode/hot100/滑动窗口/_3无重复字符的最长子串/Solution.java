package LeetCode.hot100.滑动窗口._3无重复字符的最长子串;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: Solution
 * Description: 无重复字符的最长子串
 * Author Inamikanju
 * Create 2024/2/28 20:39
 * Version 1.0
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int left = 0;
        int right = 0;
        Map<Character, Integer> map = new HashMap<>(s.length());
        while (right < s.length()) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right)) + 1);//保证left不能向左移动，比如abba，检测到3a后，left从2b移动到0a+1的位置
            }
            ans = Math.max(ans, right - left + 1);
            map.put(s.charAt(right), right);
            right++;
        }
        return ans;
    }
}
