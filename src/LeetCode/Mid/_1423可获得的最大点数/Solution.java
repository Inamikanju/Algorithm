package LeetCode.Mid._1423可获得的最大点数;

import java.util.Arrays;

/**
 * ClassName: Solution
 * Description: 可获得的最大点数
 * Author Inamikanju
 * Create 2023/12/3 11:10
 * Version 1.0
 */
public class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int window = n - k;
        int sum = 0;
        for (int i = 0; i < window; i++) {
            sum += cardPoints[i];
        }
        int minSum = sum;
        for (int i = window; i < n; i++) {
            sum = sum + cardPoints[i] - cardPoints[i - window];
            minSum = Math.min(sum, minSum);
        }
        return Arrays.stream(cardPoints).sum() - minSum;
    }
}
