package LeetCode.Mid._1657确定两个字符串是否接近;

import java.util.Arrays;

/**
 * ClassName: Solution
 * Description:确定两个字符串是否接近
 * Author Inamikanju
 * Create 2023/11/30 19:34
 * Version 1.0
 */
public class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (char c : word1.toCharArray()) {
            count1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            count2[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (count1[i] > 0 && count2[i] == 0 || count1[i] == 0 && count2[i] > 0) {
                return false;
            }
        }
        Arrays.sort(count1);
        Arrays.sort(count2);
        return Arrays.equals(count1, count2);
    }
}
