package LeetCode.hot100.回溯._78子集;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Solution
 * Description: 子集
 * Author Inamikanju
 * Create 2024/4/19 21:24
 * Version 1.0
 */
public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums.length == 0) {
            return ans;
        }
        backtrack(nums, 0);
        return ans;
    }

    private void backtrack(int[] nums, int start) {
        ans.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
