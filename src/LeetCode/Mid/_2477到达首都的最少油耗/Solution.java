package LeetCode.Mid._2477到达首都的最少油耗;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Solution
 * Description: 到达首都的最少油耗
 * Author Inamikanju
 * Create 2023/12/5 11:42
 * Version 1.0
 */
public class Solution {
    long fuelCost = 0;

    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length;
        // 创建邻接表表示图
        final List<Integer>[] g = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int[] road : roads) {
            g[road[0]].add(road[1]);
            g[road[1]].add(road[0]);
        }
        dfs(g, 0, -1, seats);
        return fuelCost;
    }

    private int dfs(List<Integer>[] g, int cur, int parent, int seats) {
        int totalPeople = 1;

        // 遍历当前节点的邻居节点
        for (Integer v : g[cur]) {
            if (v == parent) {
                continue;
            }
            int people = dfs(g, v, cur, seats);
            totalPeople += people;
            int cost = (people + seats - 1) / seats;
            fuelCost += cost;
        }
        return totalPeople;
    }
}
