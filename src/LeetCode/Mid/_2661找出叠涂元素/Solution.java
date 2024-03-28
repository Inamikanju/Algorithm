package LeetCode.Mid._2661找出叠涂元素;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: Solution
 * Description: 找出叠涂元素
 * Author Inamikanju
 * Create 2023/12/1 11:21
 * Version 1.0
 */
public class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Map<Integer, int[]> map = new HashMap<>(); // (数字,坐标)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.put(mat[i][j], new int[]{i, j});
            }
        }
        int[] mCnt = new int[m]; // 每行点亮的个数
        int[] nCnt = new int[n]; // 每列点亮的个数
        for (int i = 0; i < arr.length; i++) {
            int[] cur = map.get(arr[i]);
            mCnt[cur[0]]++;
            if (mCnt[cur[0]] == n) {
                return i;
            }
            nCnt[cur[1]]++;
            if (nCnt[cur[1]] == m) {
                return i;
            }
        }
        return -1;
    }
}
