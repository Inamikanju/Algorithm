package LeetCode.Easy._2609最长平衡子字符串;

/**
 * ClassName: Solution
 * Description: 最长平衡子字符串
 * Author Inamikanju
 * Create 2023/11/8 10:23
 * Version 1.0
 */
public class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        int ans=0;
        int[] count =new int[2];
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                if(i==0||s.charAt(i-1)=='1'){
                    count[0]=1;
                    count[1]=0;
                }
                else count[0]++;
            }
            else {
                count[1]++;
                ans=Math.max(ans, 2 * Math.min(count[0], count[1]));
            }
        }
        return ans;
    }
}
