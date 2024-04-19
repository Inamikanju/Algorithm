package LeetCode.Mid._77组合;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Solution
 * Description:
 * Author Inamikanju
 * Create 2024/4/19 19:35
 * Version 1.0
 */
public class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, k, 1);
        return ans;
    }

    private void backtrack(int n, int k, int start) {
        if (list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }
        //如果for循环选择的起始位置之后的元素个数 已经不足 我们需要的元素个数了，那么就没有必要搜索了
        //换句话说，就是4,3，已经有1个了，要保证后面一定还有2个数要够，如果后面只剩1个数了，就直接不遍历了。
        //所以要从n从后往前，腾出足够k-size个的空间，还要保证从i开始搜索可行(因为i要算进去)。n-(k-size)+1
        for (int i = start; i <= n - (k - list.size()) + 1; i++) {
            list.add(i);
            backtrack(n, k, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
