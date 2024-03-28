package LeetCode.Hard._2454下一个更大元素IV;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * ClassName: Solution
 * Description: 下一个更大元素 IV
 * Author Inamikanju
 * Create 2023/12/12 10:48
 * Version 1.0
 */
public class Solution {
    public int[] secondGreaterElement(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < nums.length; i++) {
            while (!pq.isEmpty() && pq.peek()[0] < nums[i]) {
                int[] temp = pq.poll();
                ans[temp[1]] = nums[i];
            }
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                pq.offer(new int[]{nums[stack.peek()], stack.peek()});
                stack.pop();
            }
            stack.push(i);
        }
        return ans;
    }
}
