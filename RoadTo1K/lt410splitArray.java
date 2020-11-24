package RoadTo1K;

import java.util.Arrays;

public class lt410splitArray {

    class Solution {
        /*
    prefix sum
    dp[i][m]:

    dp[0~i]: 1~m-1组的最大的largest sum
    dp[i+1~n]: i+1~n为最后一组的sum

    dp[i]: is the minimum of the largest sum in m subarrays


    x x x x x x i x x

    dp[m][n]:
    dp[k][i] = max(dp[k-1][j], j~i)
    */
        public int splitArray(int[] nums, int m) {
            int n = nums.length;
            int[] prefixSum = new int[n];
            prefixSum[0] = nums[0];
            for(int i = 1; i < n; i++){
                prefixSum[i] = prefixSum[i-1] + nums[i];
            }
            int[][] dp = new int[m + 1][n];
            //0 j
            for(int[] d : dp){
                Arrays.fill(d, Integer.MAX_VALUE);
            }
            //1 j
            for(int i = 0; i < nums.length; i++){
                dp[1][i] = prefixSum[i];
            }
            for(int k = 2; k <= m; k++){
                //要分成k组的话，最后一个的初始位置要是k，不然前面不能分配成k-1组了，
                for(int i = k - 1; i < n; i++){
                    for(int j = 0; j < i; j++){
                        dp[k][i] = Math.min(dp[k][i], Math.max(dp[k-1][j], prefixSum[i] - prefixSum[j]));
                    }
                }
            }
            return dp[m][n-1];
        }
    }


}
