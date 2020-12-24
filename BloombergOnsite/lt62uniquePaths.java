package BloombergOnsite;

public class lt62uniquePaths {
    class SolutionNSpace {
        public int uniquePaths(int m, int n) {
            int[] dp = new int[n];
            dp[0] = 1;
            for(int i = 0; i < m; i++){
                int[] tmp = new int[n];
                for(int j = 0; j < n; j++){
                    if(i == 0 && j == 0){
                        tmp[0] = dp[0];
                    }
                    else if(i == 0){
                        tmp[j] = tmp[j-1];
                    }
                    else if(j == 0){
                        tmp[j] = dp[j];
                    }else{
                        tmp[j] = tmp[j-1] + dp[j];
                    }
                }
                dp = tmp;
            }

            return dp[n-1];
        }
    }

    class Solution {
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];
            dp[0][0] = 1;
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(i == 0 && j == 0){
                        continue;
                    }
                    else if(i == 0){
                        dp[i][j] = dp[i][j-1];
                    }
                    else if(j == 0){
                        dp[i][j] = dp[i-1][j];
                    }else{
                        dp[i][j] = dp[i-1][j] + dp[i][j-1];
                    }
                }
            }

            return dp[m-1][n-1];
        }
    }
}
