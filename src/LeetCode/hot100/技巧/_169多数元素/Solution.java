package LeetCode.hot100.技巧._169多数元素;

import java.util.Arrays;

/**
 * ClassName: Solution
 * Description: 多数元素
 * Author Inamikanju
 * Create 2024/3/18 17:36
 * Version 1.0
 */
public class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
