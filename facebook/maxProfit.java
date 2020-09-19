package facebook;

public class maxProfit {

    class Solution {
        public int maxProfit(int[] prices) {
            if(prices == null || prices.length == 0){
                return 0;
            }
            int ans = 0;
            int[] dp = new int[prices.length];
            dp[0] = prices[0];
            for(int i = 1; i < prices.length; i++){
                if(prices[i] > dp[i - 1]){
                    ans = Math.max(ans, prices[i] - dp[i - 1]);
                }
                dp[i] = Math.min(prices[i], dp[i - 1]);
            }
            return ans;
        }
    }
}
