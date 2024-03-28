package LeetCode.hot100.栈._20有效的括号;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: Solution
 * Description: 有效的括号
 * Author Inamikanju
 * Create 2024/3/13 17:15
 * Version 1.0
 */
public class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || stack.pop() != map.get(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
