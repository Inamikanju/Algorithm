package LeetCode.Mid._209长度最小的子数组;

/**
 * ClassName: Solution
 * Description: 长度最小的子数组
 * Author Inamikanju
 * Create 2023/11/3 16:49
 * Version 1.0
 */
public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0;
        int right=0;
        int min=Integer.MAX_VALUE;
        int sum=0;
        for(;right<nums.length;right++){
            sum+=nums[right];
            while (sum>=target){
                min=Math.min(min,right-left+1);
                sum-=nums[left];
                left++;
            }
        }
        if(min==Integer.MAX_VALUE){
            return 0;
        }
        return min;
    }
}
