package LeetCode.Mid._2300咒语和药水的成功对数;

import java.util.Arrays;

/**
 * ClassName: Solution
 * Description: 咒语和药水的成功对数
 * Author Inamikanju
 * Create 2023/11/11 14:00
 * Version 1.0
 */
public class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] ans = new int[n];
        Arrays.sort(potions);
        for (int i = 0; i < n; i++) {
            long target = (success + spells[i] - 1) / spells[i] - 1;
            ans[i] = m - binarySearch(potions, target);
        }
        return ans;
    }

    public int binarySearch(int[] arr, long target) {
        int left = 0;
        int right = arr.length - 1;
        int ans = right + 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
