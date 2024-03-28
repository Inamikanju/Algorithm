package LeetCode.Mid._907子数组的最小值之和;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ClassName: Solution
 * Description: 子数组的最小值之和
 * Author Inamikanju
 * Create 2023/11/27 13:51
 * Version 1.0
 */
public class Solution {
    private static final int MOD = 1000000007;

    public int sumSubarrayMins(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int n = arr.length;

        // dp[][]
//        int[][] dp = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            dp[i][i] = arr[i];
//            for (int j = i + 1; j < n; j++) {
//                dp[i][j] = Math.min(dp[i][j - 1], arr[j]);
//            }
//        }
//        int ans = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = i; j < n; j++) {
//                ans = (ans + dp[i][j]) % MOD;
//            }
//        }
//        return ans;

        // 不申请dp空间
//        int ans = 0;
//        for (int i = 0; i < n; i++) {
//            int min = arr[i];
//            for (int j = i; j < n; j++) {
//                min = Math.min(min, arr[j]);
//                ans = (ans + min) % MOD;
//            }
//        }
//        return ans;

        // 向左找到第一个比A[i]小的数A[left]，以及向右找到第一个比E小的数A[right]，就可以确定E的辐射范围为A[left+1:right]。
        // 左边界不包括，右边界也不包括，计算左边界或者右边界时将一侧设置为求解小于等于E的元素

        int[] left = new int[n];
        int[] right = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // 向左找第一个<=的元素
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            // 向右找第一个<的元素
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                right[i] = n;
            } else {
                right[i] = stack.peek();
            }
            stack.push(i);
        }
        long ans=0;
        for (int i = 0; i < n; i++) {
            ans = (ans + (long) (i - left[i]) * (right[i] - i) * arr[i]) % MOD;
        }
        return (int)ans;
    }
}
