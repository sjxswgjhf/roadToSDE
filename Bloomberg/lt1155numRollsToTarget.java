package Bloomberg;

public class lt1155numRollsToTarget {

    /*
    dp[i][t]: 有多少种方法用了i个骰子，得到了t
    用x个骰子，第j个面，累积到k所用的方法是，从我用x-1个骰子累积k-j所有的方法
    */
    public int numRollsToTarget(int d, int f, int target) {
        int mod = (int)1e9 + 7;
        int[][] dp = new int[d + 1][target + 1];
        dp[0][0] = 1;
        for(int i = 1; i <= d; i++){
            for(int j = 1; j <= f; j++){
                for(int k = j; k <= target; k++){
                    dp[i][j] = (dp[i][j] + dp[i - 1][k - j]) % mod;
                }
            }
        }
        return dp[d][target];
    }
}
