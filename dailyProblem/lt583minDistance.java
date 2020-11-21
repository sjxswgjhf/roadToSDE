package dailyProblem;

public class lt583minDistance {

    class Solution {
        /*
        dp[i][j]: s1:0~i,s2:0~j, the minimum number of steps to make s1 & s2 same
        xxxxx i
        yyyy j
        if i == j
        dp[i][j] = dp[i+1][j-1]
        else
        delete i
        dp[i][j] = dp[i-1][j] + 1
        delete j
        dp[i][j] = dp[i][j-1]+1
        */
        public int minDistance(String word1, String word2) {
            int m = word1.length();
            int n = word2.length();
            word1 = "#" + word1;
            word2 = "#" + word2;
            int[][] dp = new int[m+1][n+1];

            // i 0
            for(int i = 1; i <= m; i++){
                dp[i][0] = dp[i-1][0] + 1;
            }
            //0 j
            for(int j = 1; j <= n; j++){
                dp[0][j] = dp[0][j-1] + 1;
            }
            dp[0][0] = 0;
            for(int i = 1; i <= m; i++){
                for(int j = 1; j <= n; j++){
                    if(word1.charAt(i) == word2.charAt(j)){
                        dp[i][j] = dp[i-1][j-1];
                    }
                    else{
                        dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + 1;
                    }
                }
            }
            return dp[m][n];
        }
    }




}
