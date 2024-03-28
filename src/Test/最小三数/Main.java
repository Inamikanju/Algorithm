package Test.最小三数;

import java.util.Arrays;

/**
 * ClassName: Solution
 * Description:
 * Author Inamikanju
 * Create 2024/3/26 15:21
 * Version 1.0
 */
public class Main {
    private static final int[] nums = {12, 48, 78, 64, 385, 8979, 143, 78534, 487, 793, 674, 74, 6, 31, 1};

    private static void min3num() {
        sort();
        for (int i = 3; i < nums.length; i++) {
            if (nums[2] > nums[i]) {
                nums[2] = nums[i];
                sort();
            }
        }
        System.out.println(Arrays.toString(Arrays.copyOf(nums, 3)));
    }

    private static void sort() {
        swap(0, 1);
        swap(1, 2);
        swap(0, 1);
    }

    private static void swap(int a, int b) {
        if (nums[a] > nums[b]) {
            nums[a] ^= nums[b];
            nums[b] ^= nums[a];
            nums[a] ^= nums[b];
        }
    }

    public static void main(String[] args) {
        min3num();
    }
}
