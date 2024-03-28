package LeetCode.hot100.栈._739每日温度;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ClassName: Solution
 * Description: 每日温度
 * Author Inamikanju
 * Create 2024/3/16 20:52
 * Version 1.0
 */
public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int idx = stack.pop();
                ans[idx] = i - idx;
            }
            stack.push(i);
        }
        return ans;
    }
}

