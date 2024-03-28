package LeetCode.Mid._2336无限集中的最小数字;

import java.util.TreeSet;

/**
 * ClassName: SmallestInfiniteSet
 * Description: 无限集中的最小数字
 * Author Inamikanju
 * Create 2023/11/29 16:54
 * Version 1.0
 */
public class SmallestInfiniteSet {

    private int threshold;
    private TreeSet<Integer> set;

    public SmallestInfiniteSet() {
        threshold = 1;
        set = new TreeSet<>();
    }

    public int popSmallest() {
        if (set.isEmpty()) {
            threshold++;
            return threshold - 1;
        } else {
            return set.pollFirst();
        }

    }

    public void addBack(int num) {
        if (num < threshold) {
            set.add(num);
        }
    }
}
