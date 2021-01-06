package binarysearch;

public class bs161rotateCounterClockwise {


    class Solution {
        public int[][] solve(int[][] matrix) {
            //flip left and right then flip diagional
            int m = matrix.length;
            int n = matrix[0].length;
            for(int j = 0; j < n / 2; j++){
                for(int i = 0; i < m; i++){
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[i][n - j - 1];
                    matrix[i][n - j - 1] = tmp;
                }
            }
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(i == j){
                        continue;
                    }else if(i < j){
                        int tmp = matrix[i][j];
                        matrix[i][j] = matrix[j][i];
                        matrix[j][i] = tmp;
                    }
                }
            }
            return matrix;
        }
    }
}
