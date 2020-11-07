package dailyProblem;

public class lt664strangePrinter {

    class Solution {
        /*

        memo[i][j]: 从i~j需要花费的最小的cost

        */
        public int strangePrinter(String s) {
            int n = s.length();
            int[][] memo = new int[n][n];
            return print(s, memo, 0, n - 1);
        }

        private int print(String str, int[][] memo, int s, int e){
            if(s > e){
                return 0;
            }
            if(s == e){
                return 1;
            }
            if(memo[s][e] != 0){
                return memo[s][e];
            }
            //worst case
            int res = print(str, memo, s, e - 1) + 1;
            for(int i = s; i < e; i++){
                if(str.charAt(i) == str.charAt(e)){
                    res = Math.min(res, print(str, memo, s, i) + print(str, memo, i + 1, e - 1));
                }
            }
            memo[s][e] = res;
            return memo[s][e];
        }
    }
}
