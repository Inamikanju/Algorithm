package LeetCode.Mid._438找到字符串中所有字母异位词;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: Solution
 * Description: 找到字符串中所有字母异位词
 * Author Inamikanju
 * Create 2023/11/9 15:21
 * Version 1.0
 */
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans =new ArrayList<>();
        int sLen=s.length();
        int pLen=p.length();
        if(sLen<pLen){
            return ans;
        }
        int[] sCount=new int[26];
        int[] pCount=new int[26];
        int left=0;
        int right=0;
        for(;right<pLen;right++){
            sCount[s.charAt(right)-'a']++;
            pCount[p.charAt(right)-'a']++;
        }
        if(Arrays.equals(sCount,pCount)){
            ans.add(left);
        }
        for(;right<sLen;right++,left++){
            sCount[s.charAt(right)-'a']++;
            sCount[s.charAt(left)-'a']--;
            if(Arrays.equals(sCount,pCount)){
                ans.add(left+1);
            }
        }
        return ans;
    }
}
