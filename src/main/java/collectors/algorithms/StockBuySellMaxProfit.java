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
        int[] prices = {7, 1, 5, 3, 7, 7};
        System.out.println(maxProfit(new int[] {})); // Expected 0
        System.out.println(maxProfit(null)); // Expected 0
        System.out.println(maxProfit(new int[] {5})); // Expected 0
        System.out.println(maxProfit(new int[] {5, 5, 5, 5})); // Expected 0
        System.out.println(maxProfit(new int[] {9, 6, 4, 2})); // Expected 0
        System.out.println(maxProfit(new int[] {1, 2, 3, 4})); // Expected 3
        System.out.println(maxProfit(new int[] {7, 1, 5, 3, 6, 4})); // Expected 5


    }
}
