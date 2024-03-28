package LeetCode.Mid._151反转字符串中的单词;

/**
 * ClassName: Solution
 * Description: 反转字符串中的单词
 * Author Inamikanju
 * Create 2023/11/13 16:50
 * Version 1.0
 */
public class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = removeSpace(s);
        reverse(sb, 0, sb.length() - 1);
        reverseEachWord(sb);
        return sb.toString();
    }

    public StringBuilder removeSpace(String s) {
        StringBuilder sb = new StringBuilder();
        int left = 0;
        int right = s.length() - 1;
        while (s.charAt(left) == ' ') left++;
        while (s.charAt(right) == ' ') right--;
        while (left <= right) {
            char c = s.charAt(left);
            if (c != ' ') {
                sb.append(c);
            } else if (sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            left++;
        }
        return sb;
    }

    public void reverse(StringBuilder sb, int left, int right) {
        while (left < right) {
            char temp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, temp);
            left++;
            right--;
        }
    }

    public void reverseEachWord(StringBuilder sb) {
        int left = 0;
        int right = 0;
        while (right < sb.length()) {
            while (right < sb.length() && sb.charAt(right) != ' ') {
                right++;
            }
            reverse(sb, left, right - 1);
            left = right + 1;
            right = left;
        }
    }
}
