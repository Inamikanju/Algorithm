package LeetCode.Mid._1670设计前中后队列;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ClassName: Solution
 * Description: 设计前中后队列
 * Author Inamikanju
 * Create 2023/11/28 11:33
 * Version 1.0
 */
public class FrontMiddleBackQueue {
    private Deque<Integer> left;
    private Deque<Integer> right;

    // 保证 left >= right

    public FrontMiddleBackQueue() {
        left = new ArrayDeque<>();
        right = new ArrayDeque<>();
    }

    public void pushFront(int val) {
        left.offerFirst(val);
        if (left.size() > right.size() + 1) {
            right.offerFirst(left.pollLast());
        }
    }

    public void pushMiddle(int val) {
        if (left.size() > right.size()) {
            right.offerFirst(left.pollLast());
        }
        left.offerLast(val);
    }

    public void pushBack(int val) {
        right.offerLast(val);
        if (left.size() < right.size()) {
            left.offerLast(right.pollFirst());
        }
    }

    public int popFront() {
        if (left.isEmpty()) {
            return -1;
        }
        int val = left.pollFirst();
        if (left.size() < right.size()) {
            left.offerLast(right.pollFirst());
        }
        return val;
    }

    public int popMiddle() {
        if (left.isEmpty()) {
            return -1;
        }
        int val = left.pollLast();
        if (left.size() < right.size()) {
            left.offerLast(right.pollFirst());
        }
        return val;
    }

    public int popBack() {
        if (left.isEmpty()) {
            return -1;
        }
        if (right.isEmpty()) {
            return left.pollLast();
        }
        int val = right.pollLast();
        if (left.size() > right.size() + 1) {
            right.offerFirst(left.pollLast());
        }
        return val;
    }
}
