package LeetCode.Hard._4寻找两个正序数组的中位数;

/**
 * ClassName: Solution
 * Description: 寻找两个正序数组的中位数
 * Author Inamikanju
 * Create 2023/11/13 17:32
 * Version 1.0
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int k = (m + n + 1) / 2;//3->2;4->2,3
        int left = 0;
        int right = m;
        while (left < right) {
            int s1 = left + (right - left) / 2;
            int s2 = k - s1;
            if (nums1[s1] < nums2[s2 - 1]) {
                left = s1 + 1;
            } else {
                right = s1;
            }
        }
        int t1 = left;
        int t2 = k - left;
        int c1 = Math.max(t1 <= 0 ? Integer.MIN_VALUE : nums1[t1 - 1], t2 <= 0 ? Integer.MIN_VALUE : nums2[t2 - 1]);
        if ((m + n) % 2 == 1) {
            return c1;
        }
        int c2 = Integer.min(t1 >= m ? Integer.MAX_VALUE : nums1[t1], t2 >= n ? Integer.MAX_VALUE : nums2[t2]);
        return (c1 + c2) * 0.5;
    }
}
