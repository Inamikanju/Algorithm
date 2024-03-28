package LeetCode.Easy._2558从数量最多的堆取走礼物;

import java.util.PriorityQueue;

/**
 * ClassName: Solution
 * Description: 从数量最多的堆取走礼物
 * Author Inamikanju
 * Create 2023/11/24 12:03
 * Version 1.0
 */
public class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);//比较器表达式真，则交换位置
        for (int gift : gifts) {
            priorityQueue.offer(gift);
        }
        while (k > 0) {
            int n = priorityQueue.poll();
            n = (int) Math.sqrt(n);
            priorityQueue.offer(n);
            k--;
        }
        long ans = 0;
        while (!priorityQueue.isEmpty()) {
            ans += priorityQueue.poll();
        }
        return ans;
    }
}
