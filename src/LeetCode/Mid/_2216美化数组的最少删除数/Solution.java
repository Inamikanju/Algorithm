package LeetCode.Mid._2216美化数组的最少删除数;

/**
 * ClassName: Solution
 * Description: 美化数组的最少删除数
 * Author Inamikanju
 * Create 2023/11/21 15:37
 * Version 1.0
 */
public class Solution {
    public int minDeletion(int[] nums) {
        int ans=0;
        int n=nums.length;
        boolean flag=true;//偶数下标
        for(int i=0;i<n-1;i++,flag=!flag){
            if(nums[i]==nums[i+1]&&flag){
                ans++;
                flag=false;
            }
        }
        if((n-ans)%2==1){
            ans++;
        }
        return ans;
    }
}
