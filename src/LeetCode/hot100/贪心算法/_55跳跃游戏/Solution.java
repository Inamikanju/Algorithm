package LeetCode.hot100.贪心算法._55跳跃游戏;

/**
 * ClassName: Solution
 * Description: 跳跃游戏
 * Author Inamikanju
 * Create 2024/3/13 16:15
 * Version 1.0
 */
public class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int right = 0;
        for (int i = 0; i < n; i++) {
            if (i <= right) {
                right = Math.max(right, i + nums[i]);
            }
            if (right >= n - 1) {
                return true;
            }
        }
        return false;
    }
}
