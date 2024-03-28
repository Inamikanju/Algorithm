package LeetCode.Easy._541反转字符串II;

/**
 * ClassName: Solution
 * Description: 反转字符串 II
 * Author Inamikanju
 * Create 2023/11/13 16:38
 * Version 1.0
 */
public class Solution {
    public String reverseStr(String s, int k) {
        char[] chars=s.toCharArray();
        for(int i=0;i< chars.length;i+=2*k){
            int start=i;
            int end =Math.min(chars.length-1,start+k-1);
            while(start<end){
                chars[start]^=chars[end];
                chars[end]^=chars[start];
                chars[start]^=chars[end];
                start++;
                end--;
            }
        }
        return new String(chars);
    }
}
