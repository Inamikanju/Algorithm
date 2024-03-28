package LeetCode.Mid._53最大子数组和;

/**
 * ClassName: Solution
 * Description: 最大子数组和
 * Author Inamikanju
 * Create 2023/11/13 19:55
 * Version 1.0
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        return maxSubArraySum(nums, 0, len - 1);
    }

    public int maxCrossingSum(int[] nums, int left, int mid, int right) {
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        //计算以mid结尾的最大的子数组的和
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }
        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        //计算以mid+1开始的最大的子数组的和
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            if (sum > rightSum) {
                rightSum = sum;
            }
        }
        return leftSum + rightSum;
    }

    public int maxSubArraySum(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        int mid = left + (right - left) / 2;
        return Math.max(Math.max(maxSubArraySum(nums, left, mid),
                maxSubArraySum(nums, mid + 1, right)),
                maxCrossingSum(nums, left, mid, right));
    }
}
