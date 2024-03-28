package LeetCode.Easy._2697字典序最小回文串;

/**
 * ClassName: Solution
 * Description: 字典序最小回文串
 * Author Inamikanju
 * Create 2023/12/13 11:22
 * Version 1.0
 */
public class Solution {
    public String makeSmallestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            if (chars[i] < chars[j]) {
                chars[j] = chars[i];
            } else if (chars[i] > chars[j]) {
                chars[i] = chars[j];
            }
            i++;
            j--;
        }
        return new String(chars);
    }
}
