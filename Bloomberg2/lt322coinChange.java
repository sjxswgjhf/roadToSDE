package Bloomberg2;

import java.util.Arrays;

public class lt322coinChange {
    class Solution {
        /*
        有无限的coin

        1 2 5   11
        dp[0] = 0;
        dp[1] = 1
        dp[2] = dp[1] + 1 = 2 || dp[0] + 1 = 1
        dp[3] = dp[2] + 1 || dp[1] + 2 || dp[0] + 3 = 2

        */
        public int coinChange(int[] coins, int amount) {
            if(coins == null || coins.length == 0){
                return 0;
            }
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            Arrays.sort(coins);
            for(int i = 1; i <= amount; i++){
                for(int j = 0; j < coins.length; j++){
                    if(coins[j] > i){
                        break;
                    }else{
                        if(i == coins[j]){
                            dp[i] = 1;
                        }
                        else if(dp[i - coins[j]] != Integer.MAX_VALUE){
                            dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                        }
                    }
                }
            }
            return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
        }
    }
}
