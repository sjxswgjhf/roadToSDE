package dailyProblem;

public class lt375getMoneyAmount {

    class Solution {
        /*
        对于每个j在1~i里面， res = j + max(dp[1][j-1], dp[j+1][i])
        那么dp[i] = min(res1,..., resi)
        */
        public int getMoneyAmount(int n) {
            int[][] dp = new int[n + 1][n + 1];
            return play(dp, 1, n);
        }

        private int play(int[][] dp, int s, int e){
            if(s >= e){
                return 0;
            }
            if(dp[s][e] != 0){
                return dp[s][e];
            }
            int res = Integer.MAX_VALUE;
            for(int i = s; i <= e; i++){
                int tmp = i + Math.max(play(dp, s, i - 1), play(dp, i + 1, e));
                res = Math.min(res, tmp);
            }
            dp[s][e] = res;
            return res;
        }
    }
}
