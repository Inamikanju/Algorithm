package LeetCode.hot100.回溯._79单词搜索;

/**
 * ClassName: Solution
 * Description: 单词搜索
 * Author Inamikanju
 * Create 2024/4/20 15:55
 * Version 1.0
 */
public class Solution {
    int row;
    int col;

    public boolean exist(char[][] board, String word) {
        row = board.length;
        col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                boolean flag = backtrack(board, visited, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, boolean[][] visited, int i, int j, String word, int index) {
        if (board[i][j] != word.charAt(index)) {
            return false;
        } else if (index == word.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        boolean result = false;
        if (i + 1 < row) {
            if (!visited[i + 1][j]) {
                boolean flag = backtrack(board, visited, i + 1, j, word, index + 1);
                if (flag) {
                    result = true;
                }
            }
        }
        if (j + 1 < col) {
            if (!visited[i][j + 1]) {
                boolean flag = backtrack(board, visited, i, j + 1, word, index + 1);
                if (flag) {
                    result = true;
                }
            }
        }
        if (i - 1 >= 0) {
            if (!visited[i - 1][j]) {
                boolean flag = backtrack(board, visited, i - 1, j, word, index + 1);
                if (flag) {
                    result = true;
                }
            }
        }
        if (j - 1 >= 0) {
            if (!visited[i][j - 1]) {
                boolean flag = backtrack(board, visited, i, j - 1, word, index + 1);
                if (flag) {
                    result = true;
                }
            }
        }
        visited[i][j] = false;
        return result;
    }
}
