package binarysearch;

public class bs26longestPalindromicSubsequence {

    class Solution {
        public int solve(String s) {
            if(s == null || s.length() == 0){
                return 0;
            }
            int n = s.length();
            int[][] dp = new int[n][n];
            for(int l = 1; l <= n; l++){
                for(int i = 0; i <= n - l; i++){
                    int j = i + l - 1;
                    if(i == j){
                        dp[i][j] = 1;
                    }
                    else if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = Math.max(dp[i][j], dp[i+1][j-1]+2);
                    }else{
                        dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]);
                    }
                }
            }
            for(int i = 0; i< n;i++){
                for(int j = 0; j < n;j++){
                    System.out.print(dp[i][j] + " ");
                }
                System.out.println();
            }
            return dp[0][n-1];
        }
    }
}
