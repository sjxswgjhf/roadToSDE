package dailyProblem;

import java.util.Arrays;

public class lt1458maxDotProduct {
    class Solution {

    /*
    dp[i][j]: the maximum dot product between non-empty subsequences of nums1[0:i] and nums2[0:j] with the same length.
        长度为k的时候的最大的product，从0~i，跟0~j组成的

    x x x x x i
    y y y y j

    1: A[i]*B[j] pair => dp[i][j] = dp[i-1][j-1] + A[i]*B[j]
    2: A[i],B[j] no pair => dp[i][j] = max(dp[i][j-1], dp[i-1][j])
    */

        public int maxDotProduct(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;
            int[][] dp = new int[m + 1][n + 1];
            for(int i = 0; i <= m; i++){
                Arrays.fill(dp[i], Integer.MIN_VALUE / 2);
            }

            for(int i = 1; i <= m; i++){
                for(int j = 1; j <= n; j++){
                    //A[i]B[j] pair, care about the previous product is negative or not
                    dp[i][j] = Math.max(0, dp[i-1][j-1]) + nums1[i-1]*nums2[j-1];
                    dp[i][j] = Math.max(dp[i][j], Math.max(dp[i-1][j], dp[i][j-1]));
                }
            }
            return dp[m][n];
        }
    }


}
