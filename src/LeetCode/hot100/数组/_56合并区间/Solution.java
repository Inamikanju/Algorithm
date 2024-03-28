package LeetCode.hot100.数组._56合并区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * ClassName: Solution
 * Description: 合并区间
 * Author Inamikanju
 * Create 2024/3/4 23:26
 * Version 1.0
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> ans = new ArrayList<>();
        for (int[] interval : intervals) {
            int left = interval[0];
            int right = interval[1];
            if (ans.size() == 0 || ans.get(ans.size() - 1)[1] < left) {
                ans.add(new int[]{left, right});
            } else {
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], right);
            }
        }
        return ans.toArray(new int[][]{});
    }
}
