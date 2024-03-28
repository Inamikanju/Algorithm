package LeetCode.hot100.矩阵._54螺旋矩阵;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Solution
 * Description: 螺旋矩阵
 * Author Inamikanju
 * Create 2024/3/17 15:06
 * Version 1.0
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int right = col - 1;
        int top = 0;
        int bottom = row - 1;
        while (left <= right && top <= bottom) {
            //[]
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            //(]
            for (int i = top + 1; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            //结尾一定是->或↓
            if (left < right && top < bottom) {
                //()
                for (int i = right - 1; i > left; i--) {
                    ans.add(matrix[bottom][i]);
                }
                //[)
                for (int i = bottom; i > top; i--) {
                    ans.add(matrix[i][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return ans;
    }
}
