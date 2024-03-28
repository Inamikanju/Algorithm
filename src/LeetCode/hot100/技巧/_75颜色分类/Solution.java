package LeetCode.hot100.技巧._75颜色分类;

/**
 * ClassName: Solution
 * Description: 颜色分类
 * Author Inamikanju
 * Create 2024/3/18 17:49
 * Version 1.0
 */
public class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p = 0;
        int q = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                swap(nums, i, q);
                q++;
            } else if (nums[i] == 0) {
                swap(nums, i, p);
                p++;
                if (nums[i] == 1) {
                    swap(nums, i, q);
                }
                q++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
