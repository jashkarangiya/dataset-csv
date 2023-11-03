import java.util.Arrays;

public class Kavan {

    public static double fractionalKnapsack(int[] profit, int[] weight, int capacity) {
        int n = profit.length;
        Item[] items = new Item[n];

        // Create items from profit and weight arrays
        for (int i = 0; i < n; i++) {
            items[i] = new Item(i, profit[i], weight[i]);
        }

        // Sort items based on profit per unit weight (value/weight ratio)
        Arrays.sort(items, (a, b) -> Double.compare(b.valuePerWeight, a.valuePerWeight));

        double maxProfit = 0.0;

        for (Item item : items) {
            if (capacity >= item.weight) {
                maxProfit += item.profit;
                capacity -= item.weight;
            } else {
                maxProfit += (item.valuePerWeight * capacity);
                break;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] profit1 = {1, 2, 5};
        int[] weight1 = {2, 3, 4};
        int capacity1 = 5;

        // Test Case 2
        int[] profit2 = {10, 5, 15, 7, 6, 18, 3};
        int[] weight2 = {2, 3, 5, 7, 1, 4, 1};
        int capacity2 = 15;

        // Test Case 3
        int[] profit3 = {12, 10, 8, 11, 14, 7, 9};
        int[] weight3 = {4, 6, 5, 7, 3, 1, 6};
        int capacity3 = 18;

        double result1 = fractionalKnapsack(profit1, weight1, capacity1);
        double result2 = fractionalKnapsack(profit2, weight2, capacity2);
        double result3 = fractionalKnapsack(profit3, weight3, capacity3);

        System.out.println("Test Case 1: Maximum Profit = " + result1);
        System.out.println("Test Case 2: Maximum Profit = " + result2);
        System.out.println("Test Case 3: Maximum Profit = " + result3);
    }

    static class Item {
        int index;
        int profit;
        int weight;
        double valuePerWeight;

        Item(int index, int profit, int weight) {
            this.index = index;
            this.profit = profit;
            this.weight = weight;
            this.valuePerWeight = (double) profit / weight;
        }
    }
}
