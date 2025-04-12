package Arrays;

public class MaxProfit {
    public static void main(String[] args) {
        int[] price = {3, 2, 6, 5, 0, 1, 3};
        System.out.println(maxProfit(price));
    }

    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i=0;i<prices.length;i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];  // Update minimum price seen so far
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;  // Update max profit
            }
        }
        return maxProfit;
    }
}

