package LeetCode.hot100.动态规划._152乘积最大子数组;

/**
 * ClassName: Solutiom
 * Description: 乘积最大子数组
 * Author Inamikanju
 * Create 2024/3/12 16:23
 * Version 1.0
 */
public class Solution {
    public int maxProduct(int[] nums) {
        int[] fMax = new int[nums.length];
        int[] fMin = new int[nums.length];
        fMax[0] = nums[0];
        fMin[0] = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            fMax[i] = Math.max(fMax[i - 1] * nums[i], Math.max(nums[i], fMin[i - 1] * nums[i]));
            fMin[i] = Math.min(fMin[i - 1] * nums[i], Math.min(nums[i], fMax[i - 1] * nums[i]));
            ans = Math.max(fMax[i], ans);
        }
        return ans;
    }
}
