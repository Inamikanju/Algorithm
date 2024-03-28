package LeetCode.Mid._7整数反转;

/**
 * ClassName: Solution
 * Description: 整数反转
 * Author Inamikanju
 * Create 2023/11/29 18:01
 * Version 1.0
 */
public class Solution {
    public int reverse(int x) {
        boolean flag = false;
        if (x < 0) {
            x = -x;
            flag = true;
        }
        StringBuilder s = new StringBuilder(Integer.valueOf(x).toString());
        s = s.reverse();
        int ans;
        try {
            ans = Integer.parseInt(s.toString());
        } catch (Exception e) {
            return 0;
        }
        return flag ? -ans : ans;
    }
}
