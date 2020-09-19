package facebook;

public class sumRange {

    class NumMatrix {
        int[][] rowSums;
        public NumMatrix(int[][] matrix) {
            if(matrix.length == 0){
                return;
            }
            int m = matrix.length;
            int n = matrix[0].length;
            rowSums = new int[m][n];
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(j == 0){
                        rowSums[i][j] = matrix[i][0];
                    }else{
                        rowSums[i][j] = matrix[i][j] + rowSums[i][j-1];
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int res = 0;
            for(int i = row1; i <= row2; i++){
                res += col1 == 0 ? rowSums[i][col2] : rowSums[i][col2] - rowSums[i][col1 - 1];
            }
            return res;
        }
    }

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
}
