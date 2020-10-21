package dailyProblem;

import java.util.Arrays;

public class lt518coinChangeII {

    class Solution {
        /*

        dp[5]
        1 2 5
        1: 1 == 1 dp[1] = 1, dp[2] += dp[1] = 1, dp[3] = 1, dp[4] = 1, dp[5] = 1
        2: 2
        dp[2]:

        */
        public int change(int amount, int[] coins) {
            int[] dp = new int[amount + 1];
            // dp[0] = 1;
            Arrays.sort(coins);
            outer: for(int i = 0; i < coins.length; i++){
                for(int j = 1; j <= amount; j++){
                    if(coins[i] > j){
                        break outer;
                    }
                    else if(coins[i] == j){
                        dp[i]++;
                    }else{
                        if(dp[i - coins[j]] != 0){
                            dp[i] += dp[i - coins[j]];
                        }
                    }
                }
            }
            return dp[amount];
        }
    }
}
