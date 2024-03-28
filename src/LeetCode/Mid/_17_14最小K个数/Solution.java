package LeetCode.Mid._17_14最小K个数;

import java.util.PriorityQueue;

/**
 * ClassName: Solution
 * Description: 最小K个数
 * Author Inamikanju
 * Create 2024/3/22 12:25
 * Version 1.0
 */
public class Solution {
    public int[] smallestK(int[] arr, int k) {
        int[] ans = new int[k];
        if (k == 0) {
            return ans;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll();
        }
        return ans;
    }
}
