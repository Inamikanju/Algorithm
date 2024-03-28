package LeetCode.hot100.双指针._11盛最多水的容器;

/**
 * ClassName: Solution
 * Description: 盛最多水的容器
 * Author Inamikanju
 * Create 2024/2/28 14:26
 * Version 1.0
 */
public class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = 0;
        while (left < right) {
            int area = getArea(height, left, right);
            ans = Math.max(ans, area);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return ans;
    }

    private int getArea(int[] A, int i, int j) {
        return Math.min(A[i], A[j]) * (j - i);
    }
}
