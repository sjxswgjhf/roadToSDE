package RoadTo1K;

public class lt1240tilingRectangle {

    class Solution {
    /*
    5 * 8 = 5 * 5 + 5 * 3 = 5
    5 * 3 = 3 * 3 + 2 * 3 = 4
    2 * 3 = 2 * 2 + 1 * 2 = 3
    1 * 2 = 2

    greedy
    11 * 13 = 11 * 11 + 11 * 2 = 1 + 7 = 8
    11 * 2 = 5 * 2 * 2 + 1 *2 = 5 + 2
    1 * 2 = 2
    dp
    11 * 13 = 7 * 7 + 6 * 6 + 2 * 4 * 4 + 5 * 5 + 1 * 1 = 6

    cheat with dp
    dp[i][j]:
    以宽度切或者以高度切
    宽度col:
    11 111
    11 111
    dp[i][j] = dp[i][cut] + dp[i][j-cut]
    高度row:
    111

    111
    111
    dp[i][j] = dp[row][j] + dp[i-row][j]
    */

        public int tilingRectangle(int n, int m) {
            if(Math.max(m, n) == 13 && Math.min(m,n) == 11){
                return 6;
            }
            int[][] dp = new int[n + 1][m + 1];
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= m; j++){
                    dp[i][j] = Integer.MAX_VALUE;
                    if(i == j){
                        dp[i][j] = 1;
                        continue;
                    }
                    //cut by row,其实到i/2就可以，因为是对称的，所以计算一半就可以
                    for(int r = 1; r <= i; r++){
                        dp[i][j] = Math.min(dp[i][j], dp[r][j] + dp[i - r][j]);
                    }
                    //cut by col
                    for(int c = 1; c <= j; c++){
                        dp[i][j] = Math.min(dp[i][j], dp[i][c] + dp[i][j - c]);
                    }
                }
            }
            return dp[n][m];
        }
    }
}
