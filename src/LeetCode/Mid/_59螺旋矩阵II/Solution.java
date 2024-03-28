package LeetCode.Mid._59螺旋矩阵II;

/**
 * ClassName: Solution
 * Description: 螺旋矩阵 II
 * Author Inamikanju
 * Create 2023/11/3 17:54
 * Version 1.0
 */
public class Solution {
    public int[][] generateMatrix(int n) {
        int startX = 0;
        int startY = 0;
        int loop = 0;
        int num = 1;
        int x = 0;
        int y = 0;
        int[][] ans = new int[n][n];
        while (loop < n / 2) {
            loop++;
            for (y = startY; y < n - loop; y++) {
                ans[startX][y] = num;
                num++;
            }
            for (x = startX; x < n - loop; x++) {
                ans[x][y] = num;
                num++;
            }
            for (; y >= loop; y--) {
                ans[x][y] = num;
                num++;
            }
            for (; x >= loop; x--) {
                ans[x][y] = num;
                num++;
            }
            startX++;
            startY++;
        }
        if (n % 2 == 1) {
            ans[startX][startY] = num;
        }
        return ans;
    }
}
