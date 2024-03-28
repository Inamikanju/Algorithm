package LeetCode.Mid._187重复的DNA序列;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: Solution
 * Description: 重复的DNA序列
 * Author Inamikanju
 * Create 2023/11/5 19:23
 * Version 1.0
 */
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans =new ArrayList<>();
        Map<String,Integer> map=new HashMap<>();

        int n=s.length();

        for(int i=0;i<=n-10;i++){
            String sub=s.substring(i,i+10);
            map.put(sub,map.getOrDefault(sub,0)+1);
            if(map.get(sub)==2){
                ans.add(sub);
            }
        }
        return ans;
    }
}
