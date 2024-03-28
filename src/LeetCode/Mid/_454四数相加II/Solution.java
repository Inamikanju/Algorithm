package LeetCode.Mid._454四数相加II;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: Solution
 * Description: 四数相加 II
 * Author Inamikanju
 * Create 2023/11/12 13:16
 * Version 1.0
 */
public class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                int sum = i + j;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        for (int i : nums3) {
            for (int j : nums4) {
                int need = -i - j;
                ans+=map.getOrDefault(need,0);
            }
        }
        return ans;
    }
}
