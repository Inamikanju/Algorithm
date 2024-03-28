package LeetCode.Easy._2586统计范围内的元音字符串数;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: Solution
 * Description: 统计范围内的元音字符串数
 * Author Inamikanju
 * Create 2023/11/7 12:44
 * Version 1.0
 */
public class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        int ans=0;
        Set<Character> set=new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        for(;left<=right;left++){
            String word=words[left];
            char i=word.charAt(0);
            char j=word.charAt(word.length()-1);
            if(set.contains(i)&&set.contains(j)){
                ans++;
            }
        }
        return ans;
    }
}
