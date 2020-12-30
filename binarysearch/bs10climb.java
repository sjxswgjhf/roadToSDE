package binarysearch;

public class bs10climb {

    class Solution {
        public int solve(int n) {
            if(n == 0){
                return 0;
            }
            long[] dp = new long[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            int mod = (int)(1e9) + 7;
            for(int i = 2; i <= n; i++){
                dp[i] = (dp[i-1] + dp[i-2]) % (mod);
            }
            return (int)(dp[n] % mod);
        }
    }

}
