package LeetCode.hot100.回溯._46全排列;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Solution
 * Description: 全排列
 * Author Inamikanju
 * Create 2024/4/19 18:53
 * Version 1.0
 */
public class Solution {
    List<List<Integer>> ans = new ArrayList<>();//结果集合
    List<Integer> list = new ArrayList<>();//结果
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return ans;
        }
        used = new boolean[nums.length];
        backtrack(nums);
        return ans;
    }

    private void backtrack(int[] nums) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));//如果满了，作为一个新集合保存
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;//遇到重复数字
            }
            used[i] = true;
            list.add(nums[i]);
            backtrack(nums);
            list.remove(list.size() - 1);
            used[i] = false;
        }
    }
}
