package LeetCode.hot100.数组._41缺失的第一个正数;

/**
 * ClassName: Solution
 * Description: 缺失的第一个正数
 * Author Inamikanju
 * Create 2024/3/7 14:45
 * Version 1.0
 */
public class Solution {
    public int firstMissingPositive(int[] nums) {
        // 外部哈希，空间O(N)
//        Set<Integer> set = new HashSet<>();
//        for (int num : nums) {
//            set.add(num);
//        }
//        for (int i = 1; i <= nums.length; i++) {
//            if (!set.contains(i)) {
//                return i;
//            }
//        }
//        return nums.length + 1;

        // 原地哈希，空间O(1)
        // N个数，即使最连续(1~N)，结果也不可能大于 N+1, [1,N+1]
        // 把 n 放在数组第 n-1 个位置
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
