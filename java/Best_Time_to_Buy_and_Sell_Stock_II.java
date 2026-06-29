/**
 * LeetCode #121 - Best Time to Buy and Sell Stock II
 *
 * Problem:
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share at a time.
 * However, you can buy it then immediately sell it on the same day.
 * Find and return the maximum profit you can achieve.
 *
 * Approach: Greedy
 * - Collect every upward price movement (valley to peak).
 * - Whenever prices[i] > prices[i-1], add the difference to profit.
 *
 * Time Complexity:  O(n)
 * Space Complexity: O(1)
 */
public class Best_Time_to_Buy_and_Sell_Stock_II {

    public int maxProfit(int[] prices) {
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;
    }

    // Test the solution
    public static void main(String[] args) {
        Best_Time_to_Buy_and_Sell_Stock_II sol = new Best_Time_to_Buy_and_Sell_Stock_II();

        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Test 1: " + sol.maxProfit(prices1)); // Expected: 7

        int[] prices2 = {1, 2, 3, 4, 5};
        System.out.println("Test 2: " + sol.maxProfit(prices2)); // Expected: 4

        int[] prices3 = {7, 6, 4, 3, 1};
        System.out.println("Test 3: " + sol.maxProfit(prices3)); // Expected: 0
    }
}
