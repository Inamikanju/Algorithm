package LeetCode.hot100.动态规划._70爬楼梯;

/**
 * ClassName: Solution
 * Description: 爬楼梯
 * Author Inamikanju
 * Create 2024/3/8 15:50
 * Version 1.0
 */
public class Solution {
    public int climbStairs(int n) {
        int a = 0;
        int b = 0;
        int c = 1;
        for (int i = 1; i <= n; i++) {
            a = b;
            b = c;
            c = a + b;

        }
        return c;
    }
}
