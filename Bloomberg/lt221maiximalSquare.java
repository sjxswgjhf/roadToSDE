package Bloomberg;

public class lt221maiximalSquare {

    /*
    最优解。DP思想，base case 是顶边或者左侧边，起点为0，如果顶边或者左侧边有1的话就是1，不然就是0
    然后后面的就取决于左边上面跟左上三个里面的min+1了
     */
    class Solution {
        public int maximalSquare(char[][] matrix) {
            if(matrix == null || matrix.length == 0){
                return 0;
            }
            int m = matrix.length;
            int n = matrix[0].length;
            int[][] dp = new int[m][n];
            int max = 0;
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(matrix[i][j] == '1'){
                        dp[i][j] = 1;
                        if(i == 0 || j == 0){
                            //do nothing
                        }
                        else{
                            dp[i][j] = Math.min(Math.min(dp[i][j-1],dp[i-1][j]), dp[i-1][j-1]) + 1;
                        }
                        max = Math.max(dp[i][j], max);
                    }
                }
            }

            return max * max;
        }
    }

    class Solution3N {
        /*
        通用解法。先求得从0，0到所有i,j的sum
        然后利用这个sum去求得i,j到i+k,j+k的sum，然后看这个sum是不是k^2,是的话就是正方形，不然的话就不是，

        */
        public int maximalSquare(char[][] matrix) {
            if(matrix == null || matrix.length == 0){
                return 0;
            }
            int m = matrix.length;
            int n = matrix[0].length;
            int[][] sum = new int[m + 1][n + 1];
            for(int i = 1; i <= m; i++){
                for(int j = 1; j <= n; j++){
                    sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + (int)(matrix[i - 1][j - 1] - '0');
                }
            }
            int ans = 0;
            for(int i = 1; i <= m; i++){
                for(int j = 1; j <= n; j++){
                    //边长为k，但是k只能取短边。。
                    for(int k = Math.min(m-i+1, n-j+1); k > 0; k--){
                        int area = sum[i + k - 1][j + k - 1] - sum[i+k-1][j-1] - sum[i-1][j+k-1] + sum[i-1][j-1];
                        //构成正方形的条件
                        if(area == k*k){
                            ans = Math.max(area, ans);
                            break;
                        }
                    }
                }
            }
            return ans;
        }
    }
}
