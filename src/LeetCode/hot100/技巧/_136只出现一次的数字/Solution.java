package LeetCode.hot100.技巧._136只出现一次的数字;

/**
 * ClassName: Solution
 * Description: 只出现一次的数字
 * Author Inamikanju
 * Create 2024/3/3 17:06
 * Version 1.0
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }
}
