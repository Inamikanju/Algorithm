package LeetCode.Easy._383赎金信;

/**
 * ClassName: Solution
 * Description: 赎金信
 * Author Inamikanju
 * Create 2023/11/9 14:57
 * Version 1.0
 */
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(magazine.length()<ransomNote.length()){
            return false;
        }
        int[] record=new int[26];
        for(char c:magazine.toCharArray()){
            record[c-'a']++;
        }
        for(char c:ransomNote.toCharArray()){
            record[c-'a']--;
        }
        for(int i:record){
            if(i<0){
                return false;
            }
        }
        return true;
    }
}
