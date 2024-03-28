package LeetCode.Mid._1466重新规划路线;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Solution
 * Description: 重新规划路线
 * Author Inamikanju
 * Create 2023/12/7 14:16
 * Version 1.0
 */
public class Solution {
    public int minReorder(int n, int[][] connections) {
        List<int[]>[] graph = new List[n];
        for (int[] connection : connections) {
            int x = connection[0];
            int y = connection[1];
            if (graph[x] == null) {
                graph[x] = new ArrayList<>();
            }
            if (graph[y] == null) {
                graph[y] = new ArrayList<>();
            }
            graph[x].add(new int[]{y, 1});
            graph[y].add(new int[]{x, 0});
        }
        return dfs(-1, 0, graph);
    }

    public int dfs(int parent, int cur, List<int[]>[] graph) {
        int ans = 0;
        for (int[] way : graph[cur]) {
            if (way[0] != parent) {
                ans += dfs(cur, way[0], graph);
                ans += way[1];
            }
        }
        return ans;
    }
}
