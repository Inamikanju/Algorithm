package LeetCode.Easy._232用栈实现队列;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ClassName: MyQueue
 * Description: 用栈实现队列
 * Author Inamikanju
 * Create 2024/4/5 17:20
 * Version 1.0
 */
public class MyQueue {
    private final Deque<Integer> s1;
    private final Deque<Integer> s2;

    public MyQueue() {
        s1 = new ArrayDeque<>();
        s2 = new ArrayDeque<>();
    }

    public void push(int x) {
        change(s1, s2);
        s1.push(x);
        change(s2, s1);
    }

    private void change(Deque<Integer> s1, Deque<Integer> s2) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
    }

    public int pop() {
        if (!s1.isEmpty()) {
            return s1.pop();
        }
        return -1;
    }

    public int peek() {
        if (!s1.isEmpty()) {
            return s1.peek();
        }
        return -1;
    }

    public boolean empty() {
        return s1.isEmpty();
    }
}
