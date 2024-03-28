package LeetCode.Mid._6Z字形变换;

/**
 * ClassName: Solution
 * Description: Z 字形变换
 * Author Inamikanju
 * Create 2023/11/29 17:23
 * Version 1.0
 */
public class Solution {
    public String convert(String s, int numRows) {
        if (numRows==1){
            return s;
        }

        int len = s.length();
        int t = 2 * (numRows - 1);    // 每轮循环的字符个数
        int n = len / t + 1;          // 循环次数
        int rows = numRows;           // 行
        int cols = n * (numRows - 1); // 列
        int x = 0;
        int y = 0;
        char[][] matrix = new char[rows][cols];

        for (int i = 0; i < n; i++) {
            int cur = 0;


            while (i * t + cur < len && cur < rows - 1) {
                char c = s.charAt(i * t + cur);
                matrix[x][y] = c;
                x++;
                cur++;
            }
            while (i * t + cur < len && cur < t) {
                char c = s.charAt(i * t + cur);
                matrix[x][y] = c;
                x--;
                y++;
                cur++;
            }

        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] != '\0') {
                    stringBuilder.append(matrix[i][j]);
                }
            }
        }
        return stringBuilder.toString();
    }
}
