package LeetCode.Easy._225用队列实现栈;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * ClassName: MyStack
 * Description: 用队列实现栈
 * Author Inamikanju
 * Create 2024/4/5 17:20
 * Version 1.0
 */
public class MyStack {
    private final Queue<Integer> q1;
    private final Queue<Integer> q2;

    public MyStack() {
        this.q1 = new ArrayDeque<>();
        this.q2 = new ArrayDeque<>();
    }

    public void push(int x) {
        change(q1, q2);
        q1.offer(x);
        change(q2, q1);
    }

    private void change(Queue<Integer> q1, Queue<Integer> q2) {
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }
    }

    public int pop() {
        if (!q1.isEmpty()) {
            return q1.poll();
        }
        return -1;
    }

    public int top() {
        if (!q1.isEmpty()) {
            return q1.peek();
        }
        return -1;
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}
