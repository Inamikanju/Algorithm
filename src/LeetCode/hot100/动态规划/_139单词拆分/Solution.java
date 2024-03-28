package LeetCode.hot100.动态规划._139单词拆分;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ClassName: Solution
 * Description: 单词拆分
 * Author Inamikanju
 * Create 2024/3/12 15:38
 * Version 1.0
 */
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        Set<String> set = new HashSet<>(wordDict);
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String substring = s.substring(j, i);
                if (set.contains(substring) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
