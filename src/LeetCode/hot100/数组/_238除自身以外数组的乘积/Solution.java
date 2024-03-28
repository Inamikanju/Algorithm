package LeetCode.hot100.数组._238除自身以外数组的乘积;

/**
 * ClassName: Solution
 * Description: 除自身以外数组的乘积
 * Author Inamikanju
 * Create 2024/3/7 14:34
 * Version 1.0
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length];
        int[] left = new int[length];
        int[] right = new int[length];
        left[0] = 1;
        right[length - 1] = 1;
        for (int i = 1; i < length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        for (int i = length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < length; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }
}
