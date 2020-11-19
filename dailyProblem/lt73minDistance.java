package dailyProblem;

public class lt73minDistance {

    /*
    x x x x x i
    y y y j

    1.insert
    dp[i][j] = dp[i][j-1]
    2.delete
    dp[i][j] = dp[i-1][j]
    3.repplace
    dp[i][j] = dp[i-1][j-1]

    */
    class Solution {
        public int minDistance(String word1, String word2) {
            int m = word1.length();
            int n = word2.length();
            word1 = "#" + word1;
            word2 = "#" + word2;
            int[][] dp = new int[m + 1][n + 1];
            for (int j = 1; j <= n; j++) {
                dp[0][j] = j;
            }
            for (int i = 1; i <= m; i++) {
                dp[i][0] = i;
            }
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (word1.charAt(i) == word2.charAt(j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        //insert
                        int po1 = dp[i][j - 1];
                        //delete
                        int po2 = dp[i - 1][j];
                        //replace
                        int po3 = dp[i - 1][j - 1];
                        dp[i][j] = Math.min(po1, Math.min(po2, po3)) + 1;
                    }
                }
            }
            return dp[m][n];
        }
    }

}