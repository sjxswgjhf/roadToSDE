package RoadTo1K;

public class lt221maximalSquare {
    class Solution {
        /*
        如果只单纯考虑左边跟上边好像是不可行的，虽然能快速找到min，但是会忽略左上这个点。
        当前cell跟前面能形成的最长的square是取决于左边上边跟左上三个地方，取最短的情况，
        */
        public int maximalSquare(char[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            int max = 0;
            int[][] dp = new int[m + 1][n + 1];
            for(int i = 1; i <= m; i++){
                for(int j = 1; j <= n; j++){
                    if(matrix[i - 1][j - 1] == '1'){
                        dp[i][j] = Math.min(dp[i][j-1], Math.min(dp[i-1][j-1], dp[i-1][j])) + 1;
                        max = Math.max(max, dp[i][j] * dp[i][j]);
                    }
                }
            }
            return max;
        }
    }

}
