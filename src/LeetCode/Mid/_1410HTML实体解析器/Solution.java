package LeetCode.Mid._1410HTML实体解析器;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: Solution
 * Description: HTML 实体解析器
 * Author Inamikanju
 * Create 2023/11/23 10:32
 * Version 1.0
 */
public class Solution {
    public String entityParser(String text) {
        Map<String, Character> map = new HashMap<>();
        map.put("&quot", '"');
        map.put("&apos", '\'');
        map.put("&amp", '&');
        map.put("&gt", '>');
        map.put("&lt", '<');
        map.put("&frasl", '/');

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '&') {
                int l = i + 1;
                int count = 5;
                while (l < text.length() && text.charAt(l) != ';' && count > 0) {
                    l++;
                    count--;
                }
                String s = text.substring(i, l);
                if (map.containsKey(s)) {
                    ans.append(map.get(s));
                    i = l;
                } else {
                    ans.append(text.charAt(i));
                }
            } else {
                ans.append(text.charAt(i));
            }
        }
        return ans.toString();
    }
}
