package LeetCode.hot100.回溯._17电话号码的字母组合;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Solution
 * Description:
 * Author Inamikanju
 * Create 2024/4/19 21:44
 * Version 1.0
 */
public class Solution {
    List<String> ans = new ArrayList<>();
    String[] str = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return ans;
        }
        backtrack(digits, 0);
        return ans;
    }

    private void backtrack(String digits, int index) {
        if (index == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        String s = str[digits.charAt(index) - '0'];
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            backtrack(digits, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
