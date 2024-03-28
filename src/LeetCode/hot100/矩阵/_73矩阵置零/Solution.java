package LeetCode.hot100.矩阵._73矩阵置零;

/**
 * ClassName: Solution
 * Description: 矩阵置零
 * Author Inamikanju
 * Create 2024/3/17 14:46
 * Version 1.0
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length; //行
        int col = matrix[0].length; //列
        boolean flagCol = false;
        boolean flagRow = false;
        //第一列标记
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                flagCol = true;
                break;
            }
        }
        //第一行标记
        for (int j = 0; j < col; j++) {
            if (matrix[0][j] == 0) {
                flagRow = true;
                break;
            }
        }
        //使用第一行和第一列标记是否有0
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //转换
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        //第一列转换
        if (flagCol) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
        //第一行转换
        if (flagRow) {
            for (int j = 0; j < col; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}
