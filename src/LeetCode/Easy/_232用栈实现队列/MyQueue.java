package LeetCode.Easy._232用栈实现队列;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ClassName: Solution
 * Description: 用栈实现队列
 * Author Inamikanju
 * Create 2023/11/28 19:57
 * Version 1.0
 */
public class MyQueue {
    private Deque<Integer> stack1;
    private Deque<Integer> stack2;

    public MyQueue() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    private void transfer() {
        if (!stack2.isEmpty()) {
            return;
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }

    public int pop() {
        transfer();
        return stack2.pop();
    }

    public int peek() {
        transfer();
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
