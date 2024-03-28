package LeetCode.Easy._2656K个元素的最大和;

import java.util.Arrays;

/**
 * ClassName: Solution
 * Description: K 个元素的最大和
 * Author Inamikanju
 * Create 2023/11/15 11:46
 * Version 1.0
 */
public class Solution {
    public int maximizeSum(int[] nums, int k) {
        int m= Arrays.stream(nums).max().getAsInt();
        return (m+m+k-1)*k/2;
    }
}
