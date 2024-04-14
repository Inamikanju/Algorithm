package codefun2000.p1793选数字;

/**
 * ClassName: Main
 * Description:
 * Author Inamikanju
 * Create 2024/4/13 16:36
 * Version 1.0
 */
import codefun2000.FastReader;

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args)throws IOException{
        Scanner sc = new Scanner(System.in);

        // YOUR CODE HERE!
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        Set<Integer> set=new HashSet<>(n);
        for(int i = 0;i<n;i++){
            int cur  = sc.nextInt();
            set.add(cur);
        }

        int ans = set.size();

        System.out.println(ans<k?ans:k);
    }
}
