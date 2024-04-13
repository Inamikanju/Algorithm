package Test.云服务计费;


/**
 * ClassName: Main
 * Description:
 * Author Inamikanju
 * Create 2024/4/10 19:07
 * Version 1.0
 */

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //读
        int n = sc.nextInt();
        sc.nextLine();
        List<Log> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            String[] split = str.split(",");
            Log log = new Log();
            list.add(log);
            log.front = split[0] + split[1] + split[2];
            log.client = split[1];
            log.factor = split[2];
            int count = Integer.parseInt(split[3]);
            if (count < 0 || count > 100) {
                count = 0;
            }
            log.count = count;
        }
        n = sc.nextInt();
        sc.nextLine();
        Map<String, Integer> price = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            String[] split = str.split(",");
            price.put(split[0], Integer.parseInt(split[1]));
        }

        //去重
        Map<String, Log> dis = new TreeMap<>();
        for (Log log : list) {
            if (!dis.containsKey(log.front)) {
                dis.put(log.front, log);
            }
        }
        list = dis.values().stream().toList();

        //求和
        Map<String, Integer> map = new TreeMap<>();//存客户，价钱
        for (Log log : list) {
            String client = log.client;
            String factor = log.factor;
            int count = log.count;
            int one = 0;
            if (price.containsKey(factor)) {
                one = price.get(factor);
            }
            map.put(client, map.getOrDefault(client, 0) + count * one);
        }

        //输出
        map.forEach((client, money) -> System.out.println(client + "," + money));
    }
}

class Log {
    String front;
    String client;
    String factor;
    int count;

    Log() {
    }
}