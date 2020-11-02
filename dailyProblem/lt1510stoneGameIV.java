package dailyProblem;

import java.util.Arrays;

public class lt1510stoneGameIV {
    class Solution {
        public boolean winnerSquareGame(int n) {
            int[] dp = new int[n + 1];
            Arrays.fill(dp, -1);
            return canwin(dp, n);
        }

        private boolean canwin(int[] dp, int n){
            //-1 not used, 0 lost, 1 win
            if(dp[n] != -1){
                return dp[n] == 0 ? false : true;
            }

            for(int i = 1; i * i <= n; i++){
                //找到了对手输的情况，我就赢了
                if(canwin(dp, n - i * i) == false){
                    dp[n] = 1;
                    return true;
                }
            }
            //找不到赢的情况
            dp[n] = 0;
            return false;
        }
    }
}
