package LeetCode.Mid._150逆波兰表达式求值;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ClassName: Solution
 * Description: 逆波兰表达式求值
 * Author Inamikanju
 * Create 2023/12/6 21:56
 * Version 1.0
 */
public class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if ("+".equals(token)) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a + b);
            } else if ("-".equals(token)) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            } else if ("*".equals(token)) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b * a);
            } else if ("/".equals(token)) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}
