package RoadTo1K;

public class lt10regularExpressionMatching {

    class Solution {
        /*
        dp[i][j] = 0~i 跟 0~j 是不是一样

        i = j: dp[i][j] = dp[i-1][j-1]
        j = .: dp[i][j] = dp[i-1][j-1]
        j = *: 如果j-1 != i || j-1 != . dp[i][j] = dp[i][j-2]  不要这两个char了
               dp[i][j] = dp[i][j-1] * = 1 || dp[i-1][j] || dp[i][j-2] * = 0



        */
        public boolean isMatch(String s, String p) {
            int m = s.length();
            int n = p.length();
            boolean[][] dp = new boolean[m + 1][n + 1];
            s = "#" + s;
            p = "#" + p;
        /*
        边界case：
        s:空
        p:空
        dp[0][0] = true;
        */
            dp[0][0] = true;
        /*
        s: x x x x x x
        p: 空
        dp[i][0]: i = 1~m
        这肯定false
        */

        /*
        s: 空
        p: y * y * y * y *
        才能是true
        那就是j是*的时候，取决于j-2是不是true，是的话才行
        */
            for(int j = 2; j <= n; j++){
                dp[0][j] = (p.charAt(j) =='*' && dp[0][j-2]);
            }

            for(int i = 1; i <= m; i++){
                for(int j = 1; j <= n; j++){
                    //如果p在j是个char，那么s在i的char一定要等于这个char
                    if(Character.isLetter(p.charAt(j))){
                        dp[i][j] = (s.charAt(i) == p.charAt(j)) && dp[i-1][j-1];
                    }
                    //如果p在j是个.，那么一定跟s在i相等
                    if(p.charAt(j) == '.'){
                        dp[i][j] = dp[i-1][j-1];
                    }
                    if(p.charAt(j) == '*'){
                        //重复0次，表示j-1跟i不想等，那只能变成0，然后取决于i,j-2
                        boolean p1 = dp[i][j-2];
                    /*
                        重复了n次，表明了前面j-1要么等于i，要么是.,并且i-1要跟j相等，那么
                        s: x x x x z z z z z
                        p: y y y z *
                        首先要确保i-1跟j匹配，即*表示了n个重复的char，那么当第i个char进来的时候，我只要看这个i跟j-1是不是一样或者j-1是不是.就可以
                    */
                        boolean p2 = ((s.charAt(i) == p.charAt(j-1)) || p.charAt(j-1) == '.') && dp[i-1][j];
                        dp[i][j] = p1 || p2;
                    }
                }
            }

            return dp[m][n];
        }
    }
}
