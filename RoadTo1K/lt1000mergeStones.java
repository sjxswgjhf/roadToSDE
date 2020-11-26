package RoadTo1K;

import java.util.Arrays;

public class lt1000mergeStones {
    class Solution {
        public int mergeStones(int[] stones, int K) {
            int m = stones.length;
        /*
        n-1 = 开始有N个，最后剩下一个，消灭了N-1个
        k-1 = merge k 个 生成 一个。等于消灭了 k-1 个
        */
            if((m-1) % (K-1) != 0){
                return -1;
            }
            int[][][] dp = new int[m][m][K +1];
            for(int i = 0; i < m; i++){
                for(int j = 0; j < m; j++){
                    Arrays.fill(dp[i][j], Integer.MAX_VALUE);
                }
            }
            dp[0][0][0] = 0;
            int[] prefix = new int[m + 1];
            for(int i = 1; i <= m; i++){
                prefix[i] = prefix[i - 1] + stones[i - 1];
            }
            //len = 1, cost = 0, 不用merge，即从i~i构成1个堆的cost=0
            for(int i = 0; i < m; i++){
                dp[i][i][1] = 0;
            }

            //l = 1的话，要分成k个区间，分不出来，所以从2开始，1单独考虑
            for(int l = 2; l <= m; l++){
                for(int i = 0; i <= m - l; i++){
                    // i = m - l, j = m in range
                    int j = i + l - 1;
                    //k - 1 = 0没有意义，所以k从2开始
                    for(int k = 2; k <= K; k++){
                        if(k > l){
                            continue;
                        }
                        for(int n = i; n < j; n++){
                            //prefix 这边有padding
                            if(dp[i][n][1] == Integer.MAX_VALUE || dp[n+1][j][k-1] == Integer.MAX_VALUE){
                                continue;
                            }
                            dp[i][j][k] = Math.min(dp[i][j][k], dp[i][n][1] + dp[n+1][j][k-1]);
                        }
                    }
                    if(dp[i][j][K] != Integer.MAX_VALUE){
                        //最后找到了i~j分成了K个piles的最小cost，我们再计算merge成1堆
                        dp[i][j][1] = dp[i][j][K] + prefix[j + 1] - prefix[i];
                    }
                }
            }
            return dp[0][m-1][1];
        }
    }

/*
3 2 4 1
k = 2

5 4 1
5 5
10 => 20

3 6 1
9 7
16 => 9 + 7 + 16

3 2 4 1
3 2 5
5 5
10 => 20

大的越晚merge最有利

N
N - (k - 1)
N - (k - 1)*2
...
k
1

N个元素怎么分成k个区间: N => K
0, ..., N - 1
如果前3个组成一个区间，那么剩下的要组成k-1个区间
dp[0][N-1][K] = dp[0][m][1] + dp[m+1][N-1][K-1] + sum[0~N-1]

dp[i][j][k] = min(dp[i][m][1] + dp[m+1][j][k-1]) i<=m<j
dp[i][j][1] = dp[i][j][k] + sum[i~j]


dp[i][j]: min cost merge from i ~ j，即i~j拆分成k个区间，

最优化的方法是:要连续merge k 堆石头，dp[i][j][k],那么最优的应该是我选i~j中的一个m来先merge起来，这个cost+剩下的merge起来
    dp[i][m][1] + dp[m+1][j][k-1]

*/
}
