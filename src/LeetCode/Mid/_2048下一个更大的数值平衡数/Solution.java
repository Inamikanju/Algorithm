package LeetCode.Mid._2048下一个更大的数值平衡数;

/**
 * ClassName: Solution
 * Description: 下一个更大的数值平衡数
 * Author Inamikanju
 * Create 2023/12/9 13:52
 * Version 1.0
 */
public class Solution {
    public int nextBeautifulNumber(int n) {
        for (int i = n + 1; i <= 1224444; i++) {
            if (isBeautiful(i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isBeautiful(int x) {
        int[] count = new int[10];
        while (x > 0) {
            count[x % 10]++;
            x /= 10;
        }
        for (int i = 0; i < 10; i++) {
            if (count[i] > 0 && count[i] != i) {
                return false;
            }
        }
        return true;
    }
}
