package DP;

public class BuyAndSellStock {
   public int maxProfit(int k, int[] prices) {
         int n = prices.length;

        if (n == 0 || k == 0) {
            return 0;
        }

        // Optimization: if k >= n/2, you can make as many transactions as you want
        // (unlimited transaction problem), since you can't profit from more than
        // n/2 non-overlapping transactions in an array of length n anyway.
        if (k >= n / 2) {
            return maxProfitUnlimited(prices);
        }

        // buy[j] = max profit after at most j buys (currently holding stock)
        // sell[j] = max profit after at most j complete transactions (not holding stock)
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];

        for (int j = 0; j <= k; j++) {
            buy[j] = Integer.MIN_VALUE;
        }

        for (int price : prices) {
            for (int j = 1; j <= k; j++) {
                buy[j] = Math.max(buy[j], sell[j - 1] - price);
                sell[j] = Math.max(sell[j], buy[j] + price);
            }
        }

        return sell[k];
    }

    private int maxProfitUnlimited(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
    
}
