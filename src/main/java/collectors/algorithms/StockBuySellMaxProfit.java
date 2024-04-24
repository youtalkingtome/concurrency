package collectors.algorithms;

public class StockBuySellMaxProfit {

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            // Update the minimum price if a new minimum is found
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            // Calculate profit if selling at current price and update maxProfit if it's higher
            else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }

    // Example usage
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        // Lets assume tht 7 is the minimm price. Now we declare the min price as 7 and max profit as 0
        // now move to 1 and if price at 1 is less than minimum price we have found the new minimum price
        // price 1 and min price is 0 .min price is 7

        // max profit =0 and min price is 7
        //price[i]=5 5 < 7 no new min price is 5 now.
        // 3< 5 min is 3
        // 6 < 3 no
        //max profit = 3 -
        System.out.println("Maximum Profit: " + maxProfit(prices));


    }
}
