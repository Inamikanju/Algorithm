package LeetCode.hot100.回溯._22括号生成;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Solution
 * Description: 括号生成
 * Author Inamikanju
 * Create 2024/4/20 15:35
 * Version 1.0
 */
public class Solution {
    List<String> ans = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        bktk(n, 0, 0);
        return ans;
    }

    private void bktk(int n, int left, int right) {
        if (left == n && right == n) {//左右括号都用了n个
            ans.add(sb.toString());
        }
        if (left < n) {//左括号剩余
            sb.append("(");
            bktk(n, left + 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < left) {//右括号数量小于左括号，如(()，这种情况下就可以添加右括号
            sb.append(")");
            bktk(n, left, right + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
