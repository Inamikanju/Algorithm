package Test.判断质数;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * ClassName: Main
 * Description:
 * Author Inamikanju
 * Create 2024/4/19 0:42
 * Version 1.0
 */
public class Main {
    static List<Integer> prime = new ArrayList<>();
    static boolean[] is_prime;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        is_prime = new boolean[n + 1];
        Eratosthenes(n);
        System.out.println(prime);
    }

    private static void Eratosthenes(int n) {
        Arrays.fill(is_prime, true);
        is_prime[0] = false;
        is_prime[1] = false;
        for (int i = 2; i < n; i++) {
            if (is_prime[i]) {
                prime.add(i);
                //标记i的倍数
                if (((long) i * i) > n) continue;
                for (int j = i * i; j <= n; j += i) {
                    is_prime[j] = false;
                }
            }
        }
    }

}
