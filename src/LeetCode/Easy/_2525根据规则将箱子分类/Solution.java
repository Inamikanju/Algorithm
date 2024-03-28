package LeetCode.Easy._2525根据规则将箱子分类;

/**
 * ClassName: Solution
 * Description: 根据规则将箱子分类
 * Author Inamikanju
 * Create 2023/11/25 20:29
 * Version 1.0
 */
public class Solution {
    public String categorizeBox(int length, int width, int height, int mass) {
        long maxD = Math.max(Math.max(length, width), height);
        long vol = (long) length * width * height;
        boolean isBulky = maxD >= 10000 || vol >= 1000000000;
        boolean isHeavy = mass >= 100;
        if (isBulky && isHeavy) {
            return "Both";
        } else if (isBulky) {
            return "Bulky";
        } else if (isHeavy) {
            return "Heavy";
        } else {
            return "Neither";
        }
    }
}
