package Bloomberg;

public class lt96numBSTrees {

    class Solution {
        /*
        1: 1
        2: 2
        3: 2 + 1 + 2 = 5
        4: 5 + 2 + 2 + 5 = 14

        需要个dp[0] = 1, 如果4的时候，以1为root，那么左边是0，右边是3，有多少种，应该是dp[0]*dp[3] = 1 * 5 = 5
        */
        public int numTrees(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for(int i = 2; i <= n; i++){
                for(int j = 1; j <= i; j++){
                    dp[i] += dp[j - 1] * dp[i - j];
                }
            }
            return dp[n];
        }
    }
}
