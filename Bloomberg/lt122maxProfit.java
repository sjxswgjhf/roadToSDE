package Bloomberg;

public class lt122maxProfit {
    class Solution {
    /*
    7,1,3,5,7,3,6,4
    buy: 1
    sell: 7
    get: 6
    buy: 3
    sell: 6
    get:3
    total: 9


    */

        public int maxProfit(int[] prices) {
            int profit = 0;
            int buy = prices[0];
            int n = prices.length;
            for(int i = 1; i < n; i++){
                if(buy > prices[i]){
                    buy = prices[i];
                }else{
                    while(i < n-1 && prices[i] < prices[i + 1]){
                        i++;
                    }

                    profit += prices[i] - buy;
                    buy = Integer.MAX_VALUE;
                }
            }
            return profit;
        }
    }
}
