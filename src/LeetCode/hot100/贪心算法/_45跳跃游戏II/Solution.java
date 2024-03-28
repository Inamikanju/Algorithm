package LeetCode.hot100.贪心算法._45跳跃游戏II;

/**
 * ClassName: Solution
 * Description: 跳跃游戏 II
 * Author Inamikanju
 * Create 2024/3/13 16:46
 * Version 1.0
 */
public class Solution {
    public int jump(int[] nums) {
        //找大的跳
        int n = nums.length;
        int end = 0;//能跳到的最大边界，每次都在i到end的范围内找最大的right，然后把范围换成i到right,相当于跳到了end处。
        int right = 0;
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {//最后一格不需要再跳
            right = Math.max(right, i + nums[i]);
            if (i == end) {
                end = right;
                ans++;
            }
        }
        return ans;
    }
}
