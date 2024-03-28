package LeetCode.hot100.哈希._49字母异位词分组;

import java.util.*;

/**
 * ClassName: Solution
 * Description: 字母异位词分组
 * Author Inamikanju
 * Create 2024/2/28 13:38
 * Version 1.0
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<>(map.values());
    }
}
