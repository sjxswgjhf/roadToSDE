package goldmansachs;

import java.util.Arrays;

public class coinChange {

    /*
    lt 322
    数组表示我们要构成当前的money需要用到几次，那么我们从1~amount，看我们用coins能构成的情况，
    11  1 2 5
    amount1: dp[1] = 1
    amount2: dp[2] = dp[1]+1 = 2 > dp[0]+2 = 1 , dp[2] = 1
    amount3: dp[3] = dp[2]+1 = 2
    amount4: dp[4] = dp[3] + 1 = 3 > dp[2] + 2 = 2
    .
    .
    .
    amount11: dp[11] = dp[10]+1 = 3 < dp[9]+2 < dp[6]+5
     */
    class Solution {
        public int coinChange(int[] coins, int amount) {
            int n = coins.length;
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;
            for(int i = 1; i <= amount; i++){
                for(int j = 0; j < n; j++){
                    if(coins[j] <= i){
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    }
                }
            }
            return dp[amount] > amount ? -1 : dp[amount];
        }
    }
}
