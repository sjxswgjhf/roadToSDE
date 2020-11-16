package dailyProblem;

public class lt1143longestCommonSubsequence {

    class Solution {

        /*

        dp[i][j]: the length of their longest common subsequence. s[0:i] and t[0:j]
        xxxx i
        yyy j
        if i == j, then dp[i][j] = dp[i-1][j-1]
        else
        dp[i][j] should either include dp[i-1][j] or dp[i][j-1]   这里表示当前不当等的情况的长度就是之前两种里面取一种long的长度
        */
        public int longestCommonSubsequence(String text1, String text2) {
            int m = text1.length();
            int n = text2.length();
            text1 = "#" + text1;
            text2 = "#" + text2;
            int[][] dp = new int[m + 1][n + 1];
            for(int i = 1; i <= m; i++){
                for(int j = 1; j <= n; j++){
                    if(text1.charAt(i) == text2.charAt(j)){
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }else{
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[m][n];
        }
    }
}
