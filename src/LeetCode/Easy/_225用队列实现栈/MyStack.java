package LeetCode.Easy._225用队列实现栈;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * ClassName: MyStack
 * Description: 用队列实现栈
 * Author Inamikanju
 * Create 2023/11/28 20:12
 * Version 1.0
 */
public class MyStack {
    private Queue<Integer> queue1;//offer poll
    private Queue<Integer> queue2;

    public MyStack() {
        queue1 = new ArrayDeque<>();
        queue2 = new ArrayDeque<>();
    }

    private void transfer(Queue<Integer> queue1, Queue<Integer> queue2) {
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
    }

    public void push(int x) {
        transfer(queue1, queue2);
        queue1.offer(x);
        transfer(queue2, queue1);
    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}
