package collectors.algorithms;

public class StockBuySell {

    public static void main(String[] args) {

        int[] prices = {7, 4, 5, 8, 9, 2, 1};
        int maxProfit = 0;
        int minPrice = prices[0];

        for (int j = 1; j < prices.length; j++) {
            if (prices[j] < minPrice)
                minPrice = prices[j];
            else if (prices[j] - minPrice > maxProfit)
            {
                maxProfit = prices[j] - minPrice;
            }

        }
    }
}
