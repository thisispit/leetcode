// LeetCode 121 - Best Time to Buy and Sell Stock
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
//
// You are given an array prices where prices[i] is the price of a stock on day i.
// You want to maximize profit by choosing a single day to buy and a different day
// to sell (must sell AFTER you buy). Return the maximum profit, or 0 if no profit.
//
// Example 1: prices = [7,1,5,3,6,4]  -> Output: 5  (buy at 1, sell at 6)
// Example 2: prices = [7,6,4,3,1]    -> Output: 0  (no profit possible)
//
// Approach: One-pass Greedy — track min price seen so far & max profit
// Time Complexity:  O(n)
// Space Complexity: O(1)

class Best_Time_to_Buy_and_Sell_Stock {
    public int maxProfit(int[] prices) {
        int minPrice  = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;           // found a cheaper buy day
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice); // try selling today
            }
        }

        return maxProfit;
    }

    // ---------- quick test ----------
    public static void main(String[] args) {
        Best_Time_to_Buy_and_Sell_Stock sol = new Best_Time_to_Buy_and_Sell_Stock();
        System.out.println(sol.maxProfit(new int[]{7, 1, 5, 3, 6, 4})); // 5
        System.out.println(sol.maxProfit(new int[]{7, 6, 4, 3, 1}));    // 0
        System.out.println(sol.maxProfit(new int[]{2, 4, 1}));           // 2
        System.out.println(sol.maxProfit(new int[]{3, 3}));              // 0
    }
}
