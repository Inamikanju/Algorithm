package LeetCode.Mid._2342数位和相等数对的最大和;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: Solution
 * Description: 数位和相等数对的最大和
 * Author Inamikanju
 * Create 2023/11/18 11:18
 * Version 1.0
 */
public class Solution {
    public int maximumSum(int[] nums) {
        int ans = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int s = getSum(num);
            if (map.containsKey(s)) {
                int sum=num+map.get(s);
                ans=Math.max(ans,sum);
                if (num > map.get(s)) {
                    map.put(s, num);
                }
            }else{
                map.put(s, num);
            }
        }
        return ans;
    }

    private int getSum(int num) {
        int s = 0;
        int n = num;
        while (n != 0) {
            s += n % 10;
            n /= 10;
        }
        return s;
    }

}
