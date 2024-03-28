package LeetCode.Mid._36有效的数独;

/**
 * ClassName: Solution
 * Description: 有效的数独
 * Author Inamikanju
 * Create 2024/3/6 23:20
 * Version 1.0
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][9];
        int[][] col = new int[9][9];
        int[][] box = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = num - '0' - 1;
                    int boxIndex = (i / 3) * 3 + j / 3;
                    if (row[i][n] == 1 || col[j][n] == 1 || box[boxIndex][n] == 1) {
                        return false;
                    }
                    row[i][n] = 1;
                    col[j][n] = 1;
                    box[boxIndex][n] = 1;
                }
            }
        }
        return true;
    }
}
