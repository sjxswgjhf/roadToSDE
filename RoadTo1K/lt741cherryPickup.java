package RoadTo1K;

public class lt741cherryPickup {

    class Solution {
        /*
        0,0 -> n-1,n-1   right down

        n-1,n-1 -> 0,0  left,top
        合一起其实就是等于两条路径从左上到右下, i,j为一条，x,y为另一条
    dp[i][j][x][y]: max{ dp[i-1][j][x-1][y], dp[i][j-1][x-1][y]
                         dp[i-1][j][x][y-1], dp[i][j-1][x][y-1]
                        } + grid[i][j] + grid[x][y]
        但是两个人的步数是相同的
        怎么保证呢，i+j给了当前路径的步数，那么另一条路径的x确定的话，y就可以被确定了，不用再去loop y值

    dp[i][j]: 在i,j这个cell能收集的最多的cherries

    如果当前cell可以走,dp[i][j]
    grid[i-1][j] != -1, dp[i-1][j]
    grid[i][j-1] != -1, dp[i][j-1]
    如果都不能走, dp[i][j] = 0


        */
        public int cherryPickup(int[][] grid) {
            int n = grid.length;
            int[][][] dp = new int[n + 1][n + 1][n + 1];

            for(int i = 0; i <= n; i++){
                for(int j = 0; j <= n; j++){
                    for(int x = 0; x <= n; x++){
                        dp[i][j][x] = Integer.MIN_VALUE;
                    }
                }
            }

            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    for(int x = 1; x <= n; x++){
                        int y = i + j - x;
                        if(y < 1 || y > n){
                            continue;
                        }else{
                            //不可达点
                            if(grid[i-1][j-1] == -1 || grid[x-1][y-1] == -1){
                                continue;
                            }
                            //初始点
                            if(i == 1 && j == 1 && x == 1){
                                dp[i][j][x] = grid[0][0];
                                continue;
                            }

                            dp[i][j][x] = Math.max(dp[i][j][x], dp[i-1][j][x-1]);
                            dp[i][j][x] = Math.max(dp[i][j][x], dp[i][j-1][x-1]);
                            dp[i][j][x] = Math.max(dp[i][j][x], dp[i-1][j][x]);
                            dp[i][j][x] = Math.max(dp[i][j][x], dp[i][j-1][x]);
                            if(i == x && y == j){
                                dp[i][j][x] += grid[i-1][j-1];
                            }
                            else{
                                dp[i][j][x] += grid[i-1][j-1] + grid[x-1][y-1];
                            }
                        }
                    }
                }
            }
            return Math.max(0, dp[n][n][n]) ;
        }
    }
}
