package Test.携程1you字符串;

import java.util.Scanner;

/**
 * ClassName: Main
 * Description:
 * Author Inamikanju
 * Create 2024/4/16 19:29
 * Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        int n = str.length();
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            if (str.charAt(i) == 'y' && str.charAt(i + 1) == 'u') {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
