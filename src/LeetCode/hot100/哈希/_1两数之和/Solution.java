package LeetCode.hot100.哈希._1两数之和;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: Solution
 * Description: 两数之和
 * Author Inamikanju
 * Create 2024/2/28 13:57
 * Version 1.0
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];
            if (map.containsKey(need)) {
                ans[0] = i;
                ans[1] = map.get(need);
                return ans;
            }
            map.put(nums[i], i);
        }
        return ans;
    }
}
