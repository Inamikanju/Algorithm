package LeetCode.hot100.栈._155最小栈;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ClassName: MinStack
 * Description: 最小栈
 * Author Inamikanju
 * Create 2024/3/16 21:08
 * Version 1.0
 */
public class MinStack {
    Deque<Integer> stack;
    Deque<Integer> minStack;

    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        minStack.push(Math.min(minStack.peek(), val));

    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
