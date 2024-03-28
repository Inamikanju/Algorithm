package Tools.KnapsackBacktracking;

/**
 * ClassName: KnapsackBacktracking
 * Description:
 * Author Inamikanju
 * Create 2023/11/15 17:26
 * Version 1.0
 */
public class KnapsackBacktracking {
    private static int maxWeight = 0;
    private static int maxValue = 0;

    public static void main(String[] args) {
        int[] weights = {2, 2, 6, 5, 4};
        int[] values = {6, 3, 5, 4, 6};
        int capacity = 10;

        knapsackBacktracking(weights, values, capacity, 0, 0, 0);
        System.out.println("最大价值: " + maxValue);
    }

    private static void knapsackBacktracking(int[] weights, int[] values, int capacity, int index, int currentWeight, int currentValue) {
        if (currentWeight <= capacity && currentValue > maxValue) {
            maxValue = currentValue;
        }

        if (index == weights.length) {
            return;
        }

        knapsackBacktracking(weights, values, capacity, index + 1, currentWeight + weights[index], currentValue + values[index]);

        knapsackBacktracking(weights, values, capacity, index + 1, currentWeight, currentValue);
    }
}
