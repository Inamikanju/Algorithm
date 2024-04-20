package LeetCode.hot100.回溯._51N皇后;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: Solution
 * Description: N皇后
 * Author Inamikanju
 * Create 2024/4/20 16:33
 * Version 1.0
 */
public class Solution {
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] c : board) {
            Arrays.fill(c, '.');
        }
        backtrack(n, 0, board);
        return ans;
    }

    private void backtrack(int n, int i, char[][] board) {
        if (i == n) {
            ans.add(array2list(board));
            return;
        }
        for (int j = 0; j < n; j++) {
            if (isValid(i, j, n, board)) {
                board[i][j] = 'Q';
                backtrack(n, i + 1, board);
                board[i][j] = '.';
            }
        }
    }

    private List<String> array2list(char[][] board) {
        List<String> list = new ArrayList<>();
        for (char[] c : board) {
            list.add(String.valueOf(c));
        }
        return list;
    }

    private boolean isValid(int row, int col, int n, char[][] board) {
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
