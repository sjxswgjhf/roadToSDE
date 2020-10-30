package dailyProblem;

public class lt877stonegame {

    /*
    跟lt485 predict winner一模一样。前后选一种 - 对方从剩下的选的收益
    最后判断都从0~n选出来的收益是不是大于0
     */
    class SolutionTD {
        public boolean stoneGame(int[] piles) {
            int n = piles.length;
            int[][] memo = new int[n][n];
            return win(piles, memo, 0, n - 1) >= 0;
        }

        private int win(int[] piles, int[][] memo, int s, int e){
            if(s == e){
                return piles[s];
            }
            if(memo[s][e] != 0){
                return memo[s][e];
            }
            int a = piles[s] - win(piles, memo, s + 1, e);
            int b = piles[e] - win(piles, memo, s, e - 1);
            memo[s][e] = Math.max(a, b);
            return memo[s][e];
        }

    }

    class SolutionBU {
        public boolean stoneGame(int[] piles) {
            int n = piles.length;
            int[][] dp = new int[n][n];
            for(int i = 0; i < n; i++){
                dp[i][i] = piles[i];
            }

            for(int i = n - 1; i >= 0; i--){
                for(int j = i + 1; j < n; j++){
                    int a = piles[i] - dp[i + 1][j];
                    int b = piles[j] - dp[i][j-1];
                    dp[i][j] = Math.max(a, b);
                }
            }
            return dp[0][n - 1] >= 0;
        }
    }
}
