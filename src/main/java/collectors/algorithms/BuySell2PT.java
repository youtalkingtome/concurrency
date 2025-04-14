package collectors.algorithms;

public class BuySell2PT {

    public static void main(String[] args) {

        int[] prices ={7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
        System.out.println(maxPrpfitBS(prices));
    }

    public static int maxPrpfitBS(int[] prices) {

        int minPrice = prices[0];
        int maxProfit = 0;
        for (int j = 1; j < prices.length; j++) {
            if (prices[j] < minPrice) {
                minPrice = prices[j];
            }
            if (prices[j] - minPrice > maxProfit) {
                maxProfit = prices[j] - minPrice;
            }
        }
        return maxProfit;

    }

    public static int maxProfit(int[] prices) {
        //Use two pointer left and right
        int left = 0;
        int right = 1;
        int maxProfit = 0;
        while (right < prices.length) {
            //check if profitable
            if (prices[left] < prices[right]) {
                int profit = prices[right] - prices[left];
                maxProfit = Math.max(maxProfit, profit);
            } else {
                left = right;
                right += 1;
            }
            return maxProfit;
        }
        return maxProfit;
    }
}
