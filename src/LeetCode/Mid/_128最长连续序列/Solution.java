package LeetCode.Mid._128最长连续序列;

import java.util.*;

/**
 * ClassName: Solution
 * Description: 最长连续序列
 * Author Inamikanju
 * Create 2024/2/27 14:16
 * Version 1.0
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 0;
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;
                while (set.contains(currentNum + 1)) {
                    currentLength++;
                    currentNum++;
                }
                ans = Math.max(ans, currentLength);
            }
        }
        return ans;
    }
}
