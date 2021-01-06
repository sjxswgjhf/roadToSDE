package binarysearch;

public class bs243diceThrow {

    class Solution {
        public int solve(int n, int faces, int total) {
            long[][] dp = new long[n + 1][total + 1];
            int mod = (int)(1e9 + 7);
            dp[0][0] = 1;
            for(int i = 1; i <= total; i++){
                for(int j = 1; j <= n; j++){
                    for(int k = 1; k <= faces; k++){
                        if(i >= k){
                            dp[j][i] += dp[j-1][i-k];
                            dp[j][i] %= mod;
                        }else{
                            continue;
                        }
                    }
                }
            }
            return (int)dp[n][total];
        }
    }
}
