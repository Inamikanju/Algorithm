package LeetCode.hot100.栈._394字符串解码;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ClassName: Solution
 * Description: 字符串解码
 * Author Inamikanju
 * Create 2024/3/16 20:12
 * Version 1.0
 */
public class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Deque<Integer> nums = new ArrayDeque<>();
        Deque<StringBuilder> sbs = new ArrayDeque<>();
        int num = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                nums.push(num);
                sbs.push(sb);
                sb = new StringBuilder();
                num = 0;
            } else if (Character.isAlphabetic(c)) {
                sb.append(c);
            } else {
                StringBuilder tmpSb = sbs.pop();
                int tmpNum = nums.pop();
                for (int i = 0; i < tmpNum; i++) {
                    tmpSb.append(sb);
                }
                sb = tmpSb;
            }
        }
        return sb.toString();
    }
}
