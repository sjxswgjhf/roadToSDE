package Bloomberg;

public class lt121maxProfit {
    class Solution {
        public int maxProfit(int[] prices) {
            if(prices == null || prices.length == 0){
                return 0;
            }
            int profit = 0;
            int price = prices[0];
            for(int i = 1; i < prices.length; i++){
                if(prices[i] > price){
                    profit = Math.max(profit, prices[i] - price);
                }else{
                    price = prices[i];
                }
            }
            return profit;
        }
    }
}
