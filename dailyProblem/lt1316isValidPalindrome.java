package dailyProblem;

import java.util.Arrays;

public class lt1316isValidPalindrome {


    /*
    dp[i][j]: 删了几个变成了palin,
     i == j : dp[i][j] = dp[i+1][j-1]
     i != j : remove i: dp[i][j] = dp[i+1][j] + 1
              remove j: dp[i][j] = dp[i][j-1] + 1
    */
    class SolutionRecursion {
        public boolean isValidPalindrome(String s, int k) {
            int n = s.length();
            int[][] dp = new int[n][n];
            for(int i = 0 ; i< n; i++){
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }
            return helper(dp, s,0,n - 1) <= k;
        }

        private int helper(int[][] dp, String s, int l, int r){
            if(l >= r){
                return 0;
            }
            if(dp[l][r] != Integer.MAX_VALUE){
                return dp[l][r];
            }
            int steps = 0;
            if(s.charAt(l) == s.charAt(r)){
                steps = helper(dp, s, l + 1, r- 1);
            }
            else{
                steps = 1 + Math.min(helper(dp, s, l + 1, r), helper(dp, s, l, r - 1));
            }
            dp[l][r] = steps;
            return dp[l][r];
        }
    }


}
