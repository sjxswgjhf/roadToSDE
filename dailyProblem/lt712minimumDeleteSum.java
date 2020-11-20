package dailyProblem;

import java.util.Arrays;

public class lt712minimumDeleteSum {

    /*

            dp[i][j]: minimum cost to make two string equal

            xxxxxx i
            yyyyy j

            i == j:
            dp[i][j] = dp[i-1][j-1]
            i != j:
            删除i,把j留给后面匹配
                    pos1 = dp[i][j-1]+delete(i)
            删除j，把i留给后面匹配
                    po2 = dp[i-1][j]+delete(j)
            或者都删掉？
            po3 = dp[i-1][j-1] + delete(i)+delete(j)

     */
    class Solution {
        public int minimumDeleteSum(String s1, String s2) {
            int m = s1.length();
            int n = s2.length();
            s1 = "#" + s1;
            s2 = "#" + s2;
            int[][] dp = new int[m + 1][n + 1];
            for(int i = 0; i <= m; i++){
                Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
            }

            dp[0][0] = 0;
            //i 0
            for(int i = 1; i <= m; i++){
                dp[i][0] = dp[i-1][0] + (int)(s1.charAt(i));
            }
            //0 j
            for(int j = 1; j <= n; j++){
                dp[0][j] = dp[0][j-1] + (int)(s2.charAt(j));
            }

            for(int i = 1; i <= m; i++){
                for(int j = 1; j <= n; j++){
                    if(s1.charAt(i) == s2.charAt(j)){
                        dp[i][j] = dp[i-1][j-1];
                    }else{
                        //delete i,那么i-1跟j要相等
                        int cost1 = dp[i-1][j] + (int)(s1.charAt(i));
                        //delete j, 那么i跟j-1要相等
                        int cost2 = dp[i][j-1] + (int)(s2.charAt(j));
                        dp[i][j] = Math.min(dp[i][j], Math.min(cost1, cost2));
                    }
                }
            }
            return dp[m][n];
        }
    }
}
