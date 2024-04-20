package LeetCode.hot100.回溯._39组合总和;

import sun.misc.Unsafe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: Solution
 * Description: 组合总和
 * Author Inamikanju
 * Create 2024/4/20 15:04
 * Version 1.0
 */
public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        //先拿自己，然后往后
        backtrack(candidates, target, 0, 0);
        return ans;
    }

    private void backtrack(int[] candidates, int target, int sum, int start) {
        if (sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = start; i < candidates.length && sum + candidates[i] <= target; i++) {
            sum += candidates[i];
            path.add(candidates[i]);
            backtrack(candidates, target, sum, i);
            path.remove(path.size() - 1);
            sum -= candidates[i];
        }
    }
}
