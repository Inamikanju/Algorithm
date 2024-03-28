package LeetCode.Mid._54螺旋矩阵;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Solution
 * Description: 螺旋矩阵
 * Author Inamikanju
 * Create 2023/11/3 18:35
 * Version 1.0
 */
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> ans=new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ans;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int left = 0;
        int right = columns - 1;
        int top = 0;
        int bottom = rows - 1;

        while (left <= right && top <= bottom) {
            for (int j = left; j <= right; j++) {//[]
                ans.add(matrix[top][j]);
            }
            for (int i = top + 1; i <= bottom; i++) {//(]
                ans.add(matrix[i][right]);
            }
            if (left < right && top < bottom) {
                for (int j = right - 1; j > left; j--) {//()
                    ans.add(matrix[bottom][j]);
                }
                for (int i = bottom; i > top; i--) {//[)
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
