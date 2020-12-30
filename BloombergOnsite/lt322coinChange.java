package BloombergOnsite;

import java.util.Arrays;

public class lt322coinChange {

    class Solution {
        /*
        [1,2,5]
        dp[0] = 0
        dp[1] = 1
        dp[2] = 1 dp[1]+1 || dp[2]
        dp[3] = dp[2] + 1 && dp[1] + 2 = 2 + 1 = 3
        */
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, Integer.MAX_VALUE / 2);
            dp[0] = 0;
            for(int i = 1; i <= amount; i++){
                for(int j = 0; j < coins.length; j++){
                    int coin = coins[j];
                    if(coin > i){
                        continue;
                    }
                    else{
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    }
                }
            }
            return dp[amount] == Integer.MAX_VALUE / 2 ? -1 : dp[amount];
        }
    }
}

