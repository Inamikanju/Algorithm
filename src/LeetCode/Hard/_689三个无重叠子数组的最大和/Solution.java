package LeetCode.Hard._689三个无重叠子数组的最大和;

/**
 * ClassName: Solution
 * Description: 三个无重叠子数组的最大和
 * Author Inamikanju
 * Create 2023/11/19 11:15
 * Version 1.0
 */
public class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {//三窗口一起滑，但是只记录最大值
        int[] ans = new int[3];
        int sum1 = 0, sum2 = 0, sum3 = 0;
        int maxSum1 = 0, maxSum2 = 0, maxSum3 = 0;
        int maxSum1Index = 0, maxSum2Index1 = 0, maxSum2Index2 = 0;
        for (int i = 2 * k; i < nums.length; i++) {//每次(加,判断,减)，保持循环外始终是k-1
            sum1 += nums[i - k * 2];
            sum2 += nums[i - k];
            sum3 += nums[i];
            if (i >= k * 3 - 1) {
                if (sum1 > maxSum1) {//更新1的下标
                    maxSum1 = sum1;
                    maxSum1Index = i - k * 3 + 1;
                }
                if (sum2 + maxSum1 > maxSum2) {//更新1和2的下标
                    maxSum2 = sum2 + maxSum1;
                    //如果1更新了，但是2不需要更新(`3,7,6,5,1` 3+7->7+6 6+5->5+1)
                    //那么1和2的下标应当不变，所以在2中应该单独存储1的下标
                    maxSum2Index1 = maxSum1Index;
                    maxSum2Index2 = i - k * 2 + 1;
                }
                if (sum3 + maxSum2 > maxSum3) {//更新1,2,3的下标
                    maxSum3 = sum3 + maxSum2;
                    ans[0] = maxSum2Index1;
                    ans[1] = maxSum2Index2;
                    ans[2] = i - k + 1;
                }
                sum1 -= nums[i - k * 3 + 1];
                sum2 -= nums[i - k * 2 + 1];
                sum3 -= nums[i - k + 1];
            }
        }
        return ans;
    }

    public int[] maxSumOfOneSubarray(int[] nums, int k) {//单窗口
        int[] ans = new int[1];
        int sum1 = 0;
        int maxSum1 = 0;
        for (int i = 0; i < nums.length; i++) {
            sum1 += nums[i];
            if (i >= k - 1) {
                if (sum1 > maxSum1) {
                    maxSum1 = sum1;
                    ans[0] = i - k + 1;
                }
                sum1 -= nums[i - k + 1];
            }
        }
        return ans;
    }

    public int[] maxSumOfTwoSubarrays(int[] nums, int k) {//双窗口
        int[] ans = new int[2];
        int sum1 = 0, sum2 = 0;
        int maxSum1 = 0, maxSum2 = 0;
        int maxSum1Index = 0;
        for (int i = k; i < nums.length; i++) {
            sum1 += nums[i - k];
            sum2 += nums[i];
            if (i >= k * 2 - 1) {
                if (sum1 > maxSum1) {
                    maxSum1 = sum1;
                    maxSum1Index = i - k * 2 + 1;
                }
                if (sum2 + maxSum1 > maxSum2) {
                    maxSum2 = sum2 + maxSum1;
                    ans[0] = maxSum1Index;
                    ans[1] = i - k + 1;
                }
                sum1 -= nums[i - 2 * k + 1];
                sum2 -= nums[i - k + 1];
            }
        }
        return ans;
    }
}
