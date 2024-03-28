package LeetCode.hot100.双指针._42接雨水;

/**
 * ClassName: Solution
 * Description: 接雨水
 * Author Inamikanju
 * Create 2024/2/28 18:55
 * Version 1.0
 */
public class Solution {
    public int trap(int[] height) {
        if (height.length <= 2) {
            return 0;
        }
        int ans = 0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        left[0] = 0;
        right[height.length - 1] = 0;
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(left[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i + 1]);
        }
        for (int i = 0; i < height.length; i++) {
            ans += Math.max(Math.min(left[i], right[i]) - height[i], 0);
        }
        return ans;
    }
}
