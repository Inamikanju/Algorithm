package LeetCode.Easy._1两数之和;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: Solution
 * Description: 两数之和
 * Author Inamikanju
 * Create 2023/11/11 15:52
 * Version 1.0
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();//<访问过的数字，下标>
        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];//需要另一半
            if (map.containsKey(need)) {
                ans[1] = i;
                ans[0] = map.get(need);
                break;
            }
            map.put(nums[i], i);
        }
        return ans;
    }
}
