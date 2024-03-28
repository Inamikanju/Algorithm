package LeetCode.Mid._1094拼车;

/**
 * ClassName: Solution
 * Description: 拼车
 * Author Inamikanju
 * Create 2023/12/2 13:22
 * Version 1.0
 */
public class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] timestamp = new int[1001]; // 使用一个数组记录每个位置上的乘客数量

        // 遍历每次旅行
        for (int[] trip : trips) {
            int passengers = trip[0];
            int start = trip[1];
            int end = trip[2];

            // 在起始位置上增加乘客数量
            timestamp[start] += passengers;
            // 在终点位置上减少乘客数量
            timestamp[end] -= passengers;
        }

        int memberInCar = 0; // 记录车上成员数量

        // 遍历位置数组，计算每个位置上的乘客数量累计和
        for (int i = 0; i < timestamp.length; i++) {
            memberInCar += timestamp[i];

            // 判断是否超过座位数量
            if (memberInCar > capacity) {
                return false;
            }
        }

        return true;
    }
}
