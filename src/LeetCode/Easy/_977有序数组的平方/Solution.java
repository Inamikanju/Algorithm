package LeetCode.Easy._977有序数组的平方;

/**
 * ClassName: Sulotion
 * Description: 有序数组的平方
 * Author Inamikanju
 * Create 2023/11/3 16:18
 * Version 1.0
 */
public class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int left = 0;
        int right = n - 1;
        int i = n - 1;
        while (i >= 0) {
            if (nums[left] * nums[left] <= nums[right] * nums[right]) {
                res[i] = nums[right] * nums[right];
                right--;
                i--;
            } else {
                res[i] = nums[left] * nums[left];
                left++;
                i--;
            }
        }
        return res;
    }
}
