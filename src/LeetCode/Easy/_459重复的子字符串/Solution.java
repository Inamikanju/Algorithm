package LeetCode.Easy._459重复的子字符串;

/**
 * ClassName: Solution
 * Description: 重复的子字符串
 * Author Inamikanju
 * Create 2023/11/22 20:18
 * Version 1.0
 */
public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        return (s+s).indexOf(s, 1) != s.length();//终止条件：到s.length说明跟后面重复的重合了
    }
}
