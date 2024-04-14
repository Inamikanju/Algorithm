package codefun2000.p1795元素调整;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ClassName: Main
 * Description:
 * Author Inamikanju
 * Create 2024/4/13 17:41
 * Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int[] b = new int[m];
        for (int j = 0; j < m; j++) {
            b[j] = sc.nextInt();
        }
        Arrays.sort(b);

        long[][] dp = new long[n + 1][m + 1];//表示a[i]到b[j]需要的最少次数

        for (long[] row : dp) {
            Arrays.fill(row, Long.MAX_VALUE);
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }
        //不递减，i到j也只能到j，不能更大
        //dp[i][j]=min(dp[i-1][0->j])+|a[i]-b[j]|
        for (int i = 1; i <= n; i++) {
            long temp = dp[i - 1][0];
            for (int j = 1; j <= m; j++) {
                long dis = Math.abs(a[i - 1] - b[j - 1]);
                for (int k = 0; k <= j; k++) {
                    temp = Math.min(dp[i - 1][k], temp);
                }
                dp[i][j] = temp + dis;
            }
        }
        long ans = Arrays.stream(dp[n]).min().orElse(Long.MAX_VALUE);
        System.out.println(ans);
    }
}
