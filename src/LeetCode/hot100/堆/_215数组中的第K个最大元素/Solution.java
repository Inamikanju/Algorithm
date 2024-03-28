package LeetCode.hot100.堆._215数组中的第K个最大元素;

/**
 * ClassName: Solution
 * Description: 数组中的第K个最大元素
 * Author Inamikanju
 * Create 2024/3/24 14:18
 * Version 1.0
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int heapSize = n;
        buildMaxHeap(nums, heapSize);
        for (int i = n - 1; i > n - k; i--) {
            swap(nums, 0, i);
            heapSize--;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    private void maxHeapify(int[] nums, int i, int heapSize) {
        int l = i * 2 + 1;
        int r = i * 2 + 2;
        int largest = i;
        if (l < heapSize && nums[l] > nums[largest]) {
            largest = l;
        }
        if (r < heapSize && nums[r] > nums[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(nums, i, largest);
            maxHeapify(nums, largest, heapSize);
        }
    }

    private void buildMaxHeap(int[] nums, int heapSize) {
        for (int i = heapSize / 2; i >= 0; i--) {
            maxHeapify(nums, i, heapSize);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
