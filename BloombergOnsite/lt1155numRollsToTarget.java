package BloombergOnsite;

public class lt1155numRollsToTarget {



    /*
    dp[d][target]:

    dp[i][j]: 用i个骰子累积到j用多少种方法

    */
    class Solution {
        public int numRollsToTarget(int d, int f, int target) {
            int mod = (int)1e9 + 7;
            int[][] dp = new int[d + 1][target + 1];
            dp[0][0] = 1;
            for(int i = 1; i <= d; i++){
                for(int j = 1; j <= f; j++){
                    for(int k = j; k <= target; k++){
                        dp[i][k] = (dp[i-1][k-j] + dp[i][k] ) % mod;
                    }
                }
            }
            return dp[d][target];
        }
    }

}
