package LeetCode.hot100.堆._347前K个高频元素;

import java.util.*;

/**
 * ClassName: Solution
 * Description: 前 K 个高频元素
 * Author Inamikanju
 * Create 2024/3/24 14:39
 * Version 1.0
 */
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Queue<Integer> heap = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for (Integer key : map.keySet()) {
            if (heap.size() < k) {
                heap.offer(key);
            } else if (map.get(key) > map.get(heap.peek())) {
                heap.poll();
                heap.offer(key);
            }
        }
        for (int i = 0; i < k; i++) {
            if (!heap.isEmpty()) {
                ans[i] = heap.poll();
            }
        }
        return ans;
    }
}
