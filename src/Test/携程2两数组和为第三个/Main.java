package Test.携程2两数组和为第三个;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * ClassName: Main
 * Description:
 * Author Inamikanju
 * Create 2024/4/16 19:39
 * Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ab = new int[n];
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            ab[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            ab[i] += scanner.nextInt();
            map.put(ab[i], map.getOrDefault(ab[i], 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            int cur = scanner.nextInt();
            if (map.containsKey(cur)) {
                ans++;
                map.put(cur, map.get(cur) - 1);
                if (map.get(cur) == 0) {
                    map.remove(cur);
                }
            }
        }
        System.out.println(ans);
    }
}
