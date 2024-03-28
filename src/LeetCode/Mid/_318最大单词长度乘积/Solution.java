package LeetCode.Mid._318最大单词长度乘积;

import java.util.HashSet;

/**
 * ClassName: Solution
 * Description: 最大单词长度乘积
 * Author Inamikanju
 * Create 2023/11/6 11:36
 * Version 1.0
 */
public class Solution {
    public int maxProduct(String[] words) {
        int ans=Integer.MIN_VALUE;
        HashSet[] sets=new HashSet[words.length];
        for(int i=0;i<words.length;i++) {
            sets[i] = new HashSet<Character>();
        }
        //把所有字符存进sets数组
        for(int i=0;i< words.length;i++){
            for(int j=0;j<words[i].length();j++){
                sets[i].add(words[i].charAt(j));
            }
        }

        for(int i=0;i< words.length-1;i++){
            for(int j=i+1;j< words.length;j++) {
                boolean flag=true;
                for(Character c:(HashSet<Character>)sets[i]){
                    if(sets[j].contains(c)){
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    int n=words[i].length()*words[j].length();
                    ans=Integer.max(ans,n);
                }
            }
        }
        if(ans==Integer.MIN_VALUE){
            return 0;
        }
        return ans;
    }
}
