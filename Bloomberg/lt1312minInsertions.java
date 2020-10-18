package Bloomberg;

import java.util.Arrays;

public class lt1312minInsertions {

    /*
    最好理解的做法。DP那个做法不好理解。
     */
    class Solution {
        int[][] dp;
        public int minInsertions(String s) {

            int n = s.length();
            dp = new int[n][n];
            for(int i = 0; i < n; i++){
                Arrays.fill(dp[i], -1);
            }
            return helper(s, 0, n - 1);
        }

        public int helper(String s, int l, int r){
            if(l >= r){
                return 0;
            }
            if(dp[l][r] != -1){
                return dp[l][r];
            }
            if(s.charAt(l) == s.charAt(r)){
                dp[l][r] = helper(s, l + 1, r - 1);
            }else{
                dp[l][r] = Math.min(helper(s, l + 1, r), helper(s, l, r -1)) + 1;
            }
            return dp[l][r];
        }
    }

    class SolutionDP {
        public int minInsertions(String s) {

            int n = s.length();
            int[][] dp = new int[n][n];
            for(int l = 2; l <= n; l++){
                for(int i = 0, j = l - 1; j < n; i++, j++){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = dp[i + 1][j - 1];
                    }else{
                        dp[i][j] = Math.min(dp[i + 1][j], dp[i][j-1])+1;
                    }
                }
            }
            return dp[0][n - 1];
        }
    }

    class SolutionWrong {

        public int minInsertions(String s) {
            int l = 0, r = s.length() - 1;
            int res = 0;

            while(l < r){
                if(s.charAt(l) == s.charAt(r)){
                    l++;
                    r--;
                }
                else{
                    if(s.charAt(l) == s.charAt(r - 1)){
                        res++;
                        r--;
                    }
                    else if(s.charAt(l + 1) == s.charAt(r)){
                        res++;
                        l++;
                    }else{
                        l++;
                        r--;
                        res += 2;
                    }
                }
            }
            return res;
        }
    }
}
