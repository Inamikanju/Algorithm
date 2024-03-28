package LeetCode.hot100.多维动态规划._5最长回文子串;

/**
 * ClassName: Solution
 * Description: 最长回文子串
 * Author Inamikanju
 * Create 2024/3/20 15:33
 * Version 1.0
 */
public class Solution {
    public String longestPalindrome(String s) {
        int max = 1;
        int begin = 0;
        int sLen = s.length();
        if (sLen <= 1) {
            return s;
        }
        boolean[][] dp = new boolean[sLen][sLen];// s[i,j]是否是回文串
        for (int i = 0; i < sLen; i++) {
            dp[i][i] = true;
        }
        char[] charArray = s.toCharArray();
        for (int i = 0; i < sLen - 1; i++) {
            if (charArray[i] == charArray[i + 1]) {
                dp[i][i + 1] = true;
            }
        }
        // [1,6]要检查[2,5],但是[2,5]并没有先判断
//        for (int i = 0; i < sLen - 2; i++) {
//            for (int j = i + 2; j < sLen; j++) {
//                if (charArray[i] == charArray[j] && dp[i + 1][j - 1]) {
//                    dp[i][j] = true;
//                }
//            }
//        }
        //先判断短的
        for (int i = sLen - 3; i >= 0; i--) {
            for (int j = i + 2; j < sLen; j++) {
                if (charArray[i] == charArray[j] && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                }
            }
        }
        for (int i = 0; i < sLen; i++) {
            for (int j = i; j < sLen; j++) {
                if (dp[i][j] && j - i + 1 >= max) {
                    max = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + max);
    }
}
