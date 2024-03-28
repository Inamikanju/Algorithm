package LeetCode.Easy._20有效的括号;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ClassName: Solution
 * Description: 有效的括号
 * Author Inamikanju
 * Create 2023/11/28 20:29
 * Version 1.0
 */
public class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char d = stack.pop();
                if (d == '(' && c != ')') {
                    return false;
                }
                if (d == '[' && c != ']') {
                    return false;
                }
                if (d == '{' && c != '}') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
