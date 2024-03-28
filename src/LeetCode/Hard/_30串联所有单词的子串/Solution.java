package LeetCode.Hard._30串联所有单词的子串;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: Solution
 * Description: 串联所有单词的子串
 * Author Inamikanju
 * Create 2023/11/4 16:35
 * Version 1.0
 */
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans=new ArrayList<>();

        int m=words.length;
        int n=words[0].length();
        int ls=s.length();

        for (int i = 0; i < n; i++) {//每轮滑动窗口从i开始，每次滑n，一次记录这个次序的全部结果
            // 遍历的长度超过了整个字符串的长度，退出循环
            if (i + m * n > ls) {
                break;
            }
            // differ表示窗口中的单词频次和words中的单词频次之差
            Map<String, Integer> differ = new HashMap<String, Integer>();
            // 初始化窗口，窗口长度为num * wordLen,依次计算窗口里每个切分的单词的频次
            for (int j = 0; j < m; j++) {
                String word = s.substring(i + j * n, i + (j + 1) * n);
                differ.put(word, differ.getOrDefault(word, 0) + 1);
            }
            // 遍历words中的word，对窗口里每个单词计算差值
            for (String word : words) {
                differ.put(word, differ.getOrDefault(word, 0) - 1);
                // 差值为0时，移除掉这个word
                if (differ.get(word) == 0) {
                    differ.remove(word);
                }
            }
            // 开始滑动窗口
            for (int start = i; start < ls - m * n + 1; start += n) {
                if (start != i) {
                    // 右边的单词滑进来
                    String word = s.substring(start + (m - 1) * n, start + m * n);
                    differ.put(word, differ.getOrDefault(word, 0) + 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                    // 左边的单词滑出去
                    word = s.substring(start - n, start);
                    differ.put(word, differ.getOrDefault(word, 0) - 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                }
                // 窗口匹配的单词数等于words中对应的单词数
                if (differ.isEmpty()) {
                    ans.add(start);
                }
            }
        }
        return ans;

        //超时
//        for(int i=0;i<ls;i++){
//            if(i+m*n>ls)break;
//
//            Map<String,Integer> window=new HashMap<>();
//            for(int j=0;j<m;j++){
//                String word=s.substring(i+j*n,i+(j+1)*n);//[)
//                window.put(word,window.getOrDefault(word,0)+1);
//            }
//            for(String word:words){
//                window.put(word,window.getOrDefault(word,0)-1);
//                if(window.get(word)==0){
//                    window.remove(word);
//                }
//            }
//            if(window.isEmpty()){
//                ans.add(i);
//            }
//        }
//        return ans;
    }
}
