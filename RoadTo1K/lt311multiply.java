package RoadTo1K;

public class lt311multiply {

    class Solution {
        public int[][] multiply(int[][] A, int[][] B) {
            int ra = A.length;
            int ca = A[0].length;
            int rb = B.length;
            int cb = B[0].length;
            int[][] res = new int[ra][cb];

            for(int i = 0; i < ra; i++){
                for(int j = 0; j < cb; j++){
                    res[i][j] = calculate(A, B, i, j);
                }
            }
            return res;
        }

        private int calculate(int[][] A, int[][] B, int r, int c){
            int m = A[0].length;
            int res = 0;
            for(int i = 0; i < m; i++){
                res += A[r][i] * B[i][c];
            }
            return res;
        }
    }
}
