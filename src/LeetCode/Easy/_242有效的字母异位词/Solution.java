package LeetCode.Easy._242有效的字母异位词;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: Solution
 * Description: 有效的字母异位词
 * Author Inamikanju
 * Create 2023/11/7 14:59
 * Version 1.0
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(int i=0;i<t.length();i++){
            char c=t.charAt(i);
            map.put(c,map.getOrDefault(c,0)-1);
            if(map.get(c)==0){
                map.remove(c);
            }
        }
        return map.isEmpty();
    }
}
