package dailyProblem;

public class lt97isInterleave {

    class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            int m = s1.length();
            int n = s2.length();
            int s = s3.length();
            if(m + n != s){
                return false;
            }
            s1 = "#" + s1;
            s2 = "#" + s2;
            s3 = "#" + s3;

            boolean[][] dp = new boolean[m + 1][n + 1];
            dp[0][0] = true;
            //因为有j-1跟i-1存在，需要考虑dp[0][j]跟dp[i][0]
            //就表示前i个s1跟s3是不是一样，前j个s2跟s3是不是一样
            for(int i = 1; i <= m; i++){
                if(dp[i-1][0] && s1.charAt(i) == s3.charAt(i)){
                    dp[i][0] = true;
                }
            }

            for(int j = 1; j <= n; j++){
                if(dp[0][j - 1] && s2.charAt(j) == s3.charAt(j)){
                    dp[0][j] = true;
                }
            }

            for(int i = 1; i <= m; i++){
                for(int j = 1; j <= n; j++){
                    //s1用了i个，s2用了j个，s3就是i+j个
                    if(dp[i-1][j] && s1.charAt(i) == s3.charAt(i + j)){
                        dp[i][j] = true;
                    }
                    else if(dp[i][j - 1] && s2.charAt(j) == s3.charAt(i + j)){
                        dp[i][j] = true;
                    }
                }
            }
            return dp[m][n];
        }
    }

    class SolutionNotGood {
        /*

        dp[i][j]:
        用了s1的前i个跟s2的前j个，
        如果当前第k的s3，如果s1的i+1等于s3的k，那么i+1，j要是true，我用了s1的i+1
                       如果s2的j+1等于s3的k，那么i,j+1要true，我用了s2的j+1
        */
        public boolean isInterleave(String s1, String s2, String s3) {
            int m = s1.length();
            int n = s2.length();
            int l = s3.length();
            if(m + n != l){
                return false;
            }
            boolean[][] dp = new boolean[m+1][n+1];
            dp[0][0] = true;
            //都是从0开始，因为s3是从0~l-1
            //并且这里的k表示的是s3的idx
            for(int i = 0; i <= m; i++){
                for(int j = 0; j <= n; j++){
                    int k = i + j;
                    if(dp[i][j] == true){
                        if(i < m && s1.charAt(i) == s3.charAt(k)){
                            dp[i + 1][j] = true;
                        }
                        if(j < n && s2.charAt(j) == s3.charAt(k)){
                            dp[i][j + 1] = true;
                        }
                    }
                }
            }
            return dp[m][n];
        }
    }
}
