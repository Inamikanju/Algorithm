package LeetCode.Mid._8字符串转换整数atoi;

/**
 * ClassName: Solution
 * Description: 字符串转换整数 (atoi)
 * Author Inamikanju
 * Create 2023/11/29 20:21
 * Version 1.0
 */
public class Solution {
    public int myAtoi(String s) {
        long ans = 0L;
        int i = 0;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        int sign = 1;
        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = s.charAt(i) == '+' ? 1 : -1;
            i++;
        }
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            int a = s.charAt(i) - '0';
            ans = ans * 10 + a;
            i++;
            long tmp = ans * sign;
            if (tmp > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (tmp < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return (int) ans * sign;
    }
}
