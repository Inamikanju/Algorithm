package LeetCode.Easy._2824统计和小于目标的下标对数目;

import java.util.*;

/**
 * ClassName: Solution
 * Description: 统计和小于目标的下标对数目
 * Author Inamikanju
 * Create 2023/11/24 11:46
 * Version 1.0
 */
public class Solution {
    public int countPairs(List<Integer> nums, int target) {
        Collections.sort(nums);
        int ans=0;
        for(int i=0,j=nums.size()-1;i<j;i++){
            while(i<j&&nums.get(i)+nums.get(j)>=target){
                j--;
            }
            ans+=j-i;
        }
        return ans;
    }
}
