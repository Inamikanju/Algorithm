package LeetCode.Mid._912排序数组;

/**
 * ClassName: Solution
 * Description:
 * Author Inamikanju
 * Create 2024/4/1 16:22
 * Version 1.0
 */
public class Solution {
    public int[] sortArray(int[] nums) {
        //bubbleSort(nums);
        //quickSort(nums);
        return nums;
    }

    //快速排序
    public void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int p = partition(nums, left, right);
            quickSort(nums, left, p - 1);
            quickSort(nums, p + 1, right);
        }
    }

    private int partition(int[] nums, int left, int right) {
        swap(nums, (int) (Math.random() * (right - left + 1) + left), right);//随机选取基准放到右边界
        int p = nums[right];
        int i = left;//i从区间的左边界开始，表示要交换的位置
        for (int cur = left; cur < right; cur++) {
            if (nums[cur] <= p) {//对于当前元素，若小于或等于基准，则交换
                swap(nums, i, cur);
                i++;
            }
        }
        swap(nums, i, right);//最后将基准交换，此时基准处于正确的位置，左侧的元素都不大于基准
        return i;
    }

    //冒泡排序
    public void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
