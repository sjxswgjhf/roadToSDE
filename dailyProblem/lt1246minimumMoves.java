package dailyProblem;

import java.util.Arrays;

public class lt1246minimumMoves {

    class SolutionBU {
        public int minimumMoves(int[] arr) {
            int n = arr.length;
            int[][] dp = new int[n][n];

            for(int i = 0 ; i < n; i++){
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }
            for(int i = 0; i < n; i++){
                dp[i][i] = 1;
            }

            for(int l = 1; l < n; l++){
                for(int i = 0; i + l < n; i++){
                    int j = i + l;
                    if(arr[i] == arr[j]){
                        dp[i][j] = l >= 2 ? dp[i + 1][j - 1] : 1;
                    }
                    for(int k = i; k < j; k++){
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
                    }
                }
            }

            return dp[0][n-1];
        }
    }

    class SolutionTD {
        public int minimumMoves(int[] arr) {
            int n = arr.length;
            int[][] memo = new int[n][n];
            return getCost(arr, memo, 0, n - 1);
        }

        private int getCost(int[] arr, int[][] memo, int s, int e){

            if(s > e){
                return 0;
            }
            if(s== e){
                return 1;
            }

            if(memo[s][e] != 0 ){
                return memo[s][e];
            }
            int res = getCost(arr, memo, s, e - 1) + 1; //worst case
            if(e > 0 && arr[e] == arr[e - 1]){
                res = Math.min(res, getCost(arr, memo, s, e - 2) + 1);
            }
            for(int k = s; k < e - 1; k++){
                if(arr[k] == arr[e]){
                    res = Math.min(res, getCost(arr, memo, s, k - 1) + getCost(arr, memo, k + 1, e - 1));
                }
            }
            memo[s][e] = res;
            return memo[s][e];
        }
    }
}
