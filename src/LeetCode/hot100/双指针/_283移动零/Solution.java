package LeetCode.hot100.双指针._283移动零;

/**
 * ClassName: Solution
 * Description: 移动零
 * Author Inamikanju
 * Create 2024/2/28 14:03
 * Version 1.0
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        while (right<nums.length){
            if(nums[right]!=0){
                swap(nums,left,right);
                left++;
            }
            right++;
        }
    }

    private void swap(int[] A,int i,int j){
        int temp=A[i];
        A[i]=A[j];
        A[j]=temp;
    }
}
