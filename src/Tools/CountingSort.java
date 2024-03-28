package Tools;

import java.util.Arrays;

/**
 * ClassName: CountingSort
 * Description:
 * Author Inamikanju
 * Create 2023/11/14 15:33
 * Version 1.0
 */
public class CountingSort {
    public static void countingSort(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int min = nums[0];
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
        int range = max - min + 1;
        int[] count = new int[range];
        for (int i = 0; i < range; i++) {
            count[i] = 0;
        }
        for (int num : nums) {
            count[num - min]++;
        }
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }
        int[] sorted = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            sorted[count[nums[i] - min] - 1] = nums[i];
            count[nums[i] - min]--;
        }
        for (int i = 0; i < n; i++) {
            nums[i] = sorted[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{95, 94, 91, 98, 99, 90, 99, 93, 91, 92};
        System.out.print("排序前：");
        System.out.println(Arrays.toString(nums));
        countingSort(nums);
        System.out.print("排序后：");
        System.out.println(Arrays.toString(nums));
    }
}
