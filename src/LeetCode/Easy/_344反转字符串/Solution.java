package LeetCode.Easy._344反转字符串;

/**
 * ClassName: Solution
 * Description: 反转字符串
 * Author Inamikanju
 * Create 2023/11/13 16:34
 * Version 1.0
 */
public class Solution {
    public void reverseString(char[] s) {
        int i=0;
        int j=s.length-1;
        while(i<j) {
            s[i] ^= s[j];
            s[j] ^= s[i];
            s[i] ^= s[j];
            i++;
            j--;
        }
    }
}
