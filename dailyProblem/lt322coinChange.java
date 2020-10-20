package dailyProblem;

import java.util.Arrays;

public class lt322coinChange {

    class Solution {
        /*
        dp[i]: 表示达到i amount用的最少的数量
        dp[0]: 表示达到0，用了0个
        从1~amount，我用coins达到的数量,如果dp[i - conis[j]]存在，那么我就只要一个coins就行
        11
        dp[11]
        dp[1] = 1
        dp[2] = 1 + 1, 1
        dp[3] = 1 + 1 || 3 = 2
        dp[4] = 2 + 1= 3 || 2
        */
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, amount + 1);
            //Arrays.sort(coins);
            dp[0] = 0;
            for(int i = 1; i <= amount; i++){
                for(int j = 0; j < coins.length; j++){
                    int coin = coins[j];
                    if(coin > i){
                        //break;            不sort就要用continue
                        continue;
                    }
                    else{
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    }
                }
            }
            return dp[amount] > amount ? -1 : dp[amount];
        }
    }
}
