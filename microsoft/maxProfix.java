package microsoft;

public class maxProfix {

    class Solution {
        public int maxProfit(int[] prices) {
            if(prices == null || prices.length == 0){
                return 0;
            }
            int n = prices.length;
            int[] lowestprice = new int[n];
            lowestprice[0] = prices[0];
            int max = 0;
            for(int i = 1; i < n; i++){
                if(prices[i] > lowestprice[i-1]){
                    max = Math.max(max, prices[i] - lowestprice[i-1]);
                }
                lowestprice[i] = Math.min(lowestprice[i - 1], prices[i]);
            }
            return max;
        }
    }

}
