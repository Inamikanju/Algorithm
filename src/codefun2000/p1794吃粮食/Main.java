package codefun2000.p1794吃粮食;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * ClassName: Main
 * Description:
 * Author Inamikanju
 * Create 2024/4/13 16:37
 * Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // YOUR CODE HERE!
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        //走到这发现没粮食了，所以考虑回去之前位置买，既要便宜，又要个数少
        //优先级队列，价格低到高，次数少到多，路过此地加进队列。
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
        pq.offer(new int[]{a[0], 0, 0});
        int[] ans = new int[n];
        for (int i = 1; i < n; i++) {
            int[] top = pq.poll();
            top[1]++;
            ans[top[2]]++;
            pq.offer(top);
            pq.offer(new int[]{a[i], 0, i});
        }

        for (int i = 0; i < n; i++) {
            System.out.print(ans[i]);
            if (i < n - 1) {
                System.out.print(" ");
            }
        }

        System.out.println();
    }
}


