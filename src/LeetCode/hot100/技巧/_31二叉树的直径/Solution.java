package LeetCode.hot100.技巧._31二叉树的直径;

/**
 * ClassName: Solution
 * Description: 下一个排列
 * Author Inamikanju
 * Create 2024/3/18 18:18
 * Version 1.0
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length == 1) {
            return;
        }
        //「较小数」尽量靠右，「较大数」尽可能小
        // 交换完成后，「较大数」右边的数按照升序重新排列
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j > i && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
