package dailyProblem;

public class lt1039minScoreTriangulation {



    class SolutionTD {
        public int minScoreTriangulation(int[] A) {
            int n = A.length;
            int[][] memo = new int[n][n];

            return getScore(A, memo, 0, n -1);
        }

        private int getScore(int[] A, int[][] memo, int s, int e){
            if(s + 1 >= e){
                return 0;
            }
            if(memo[s][e] != 0){
                return memo[s][e];
            }
            int score = Integer.MAX_VALUE;
            for(int k = s + 1; k < e; k++){
                score = Math.min(score, getScore(A, memo, s, k) + getScore(A, memo, k, e) + A[s]*A[e]*A[k]);
            }
            memo[s][e] = score;
            return memo[s][e];
        }
    }

    class SolutionBU {

        /*
        dp[i][j] 以为idx i，j为边，找一个顶点构成三角形。

        1 2
      6     3
        5  4

        1-6 => 2
        [] [2 3 4 5 6]
        1-6 => 3
        [1 2 3] [3 4 5 6]
        1-6 => 4
        [1 2 3 4] [4 5 6]
        1-6 =>5
        [1 2 3 4 5] []
        区间形模板,大区间依赖小区间
        */
        public int minScoreTriangulation(int[] A) {
            int n = A.length;
            int[][] dp = new int[n][n];
            //两个端点之间的间隔范围
            for(int d = 2; d < n; d++){
                for(int i = 0; i + d < n; i++){      //三角形左端点
                    int j = i + d;      //三角形右端点
                    dp[i][j] = Integer.MAX_VALUE;
                    for(int k = i + 1; k < j; k++) {     //中间点
                        //如果ijk构成了三角形，那么另外的是从i~k跟k~j的
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + A[i] * A[j] * A[k]);
                    }
                }
            }
            return dp[0][n-1];
        }
    }
}
