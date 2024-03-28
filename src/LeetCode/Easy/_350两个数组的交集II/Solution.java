package LeetCode.Easy._350两个数组的交集II;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: Solution
 * Description: 两个数组的交集 II
 * Author Inamikanju
 * Create 2023/11/11 15:19
 * Version 1.0
 */
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int[] ans = new int[nums1.length];
        int index = 0;
        for (int i : nums2) {
            int count = map.getOrDefault(i, 0);
            if (count > 0) {
                ans[index++] = i;
                count--;
                if (count > 0) {
                    map.put(i, count);
                } else {
                    map.remove(i);
                }
            }
        }
        return Arrays.copyOfRange(ans, 0, index);
    }
}
