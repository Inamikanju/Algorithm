package LeetCode.hot100.图论._994腐烂的橘子;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * ClassName: Solution
 * Description: 腐烂的橘子
 * Author Inamikanju
 * Create 2024/3/21 20:52
 * Version 1.0
 */
public class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();//记录腐烂的橘子的坐标
        int count = 0;//新鲜橘子个数
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int ans = 0;
        while (count > 0 && !queue.isEmpty()) {
            ans++;
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int[] orange = queue.poll();
                int i = orange[0];
                int j = orange[1];
                if (i + 1 < m && grid[i + 1][j] == 1) {
                    grid[i + 1][j] = 2;
                    count--;
                    queue.offer(new int[]{i + 1, j});
                }
                if (j + 1 < n && grid[i][j + 1] == 1) {
                    grid[i][j + 1] = 2;
                    count--;
                    queue.offer(new int[]{i, j + 1});
                }
                if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                    grid[i - 1][j] = 2;
                    count--;
                    queue.offer(new int[]{i - 1, j});
                }
                if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                    grid[i][j - 1] = 2;
                    count--;
                    queue.offer(new int[]{i, j - 1});
                }
            }
        }
        if (count > 0) {
            return -1;
        }
        return ans;
    }
}
