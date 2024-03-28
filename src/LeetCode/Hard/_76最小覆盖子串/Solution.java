package LeetCode.Hard._76最小覆盖子串;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: Solution
 * Description: 最小覆盖子串
 * Author Inamikanju
 * Create 2023/11/3 17:32
 * Version 1.0
 */
public class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();//保存t的字符与数量
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        int valid = 0;//记录有效的字符(s的对应字符数量不少于t)
        int minLen = Integer.MAX_VALUE;
        int start = 0;//记录最短字串的位置
        while (right < s.length()) {
            char c = s.charAt(right);

            if (need.containsKey(c)) {//有c则加入c，没有则跳过
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            while (valid == need.size()) {
                int i = right - left + 1;
                if(i<minLen) {
                    minLen = i;
                    start = left;
                }

                char d = s.charAt(left);
                if (window.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
                left++;
            }
            right++;
        }
        if (minLen == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(start, start + minLen);
    }
}
