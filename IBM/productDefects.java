package IBM;

import java.util.List;

public class productDefects {

    public int productDefects(char[][] matrix){

        if(matrix == null || matrix.length == 0){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int size = m > n ? n : m;
        int[][] sizes = new int[m][n];
        int ans = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                sizes[i][j] = matrix[i][j] - '0';
                if(sizes[i][j] == 0){
                    continue;
                }
                if(i == 0 || j == 0){

                }
                else if(i == 0){
                    sizes[i][j] = sizes[i][j - 1] + 1;
                }else if(j == 0){
                    sizes[i][j] = sizes[i-1][j] + 1;
                }else{
                    sizes[i][j] = Math.min(Math.min(sizes[i-1][j-1], sizes[i-1][j]), sizes[i][j-1])+1;
                }
                ans = Math.max(ans, sizes[i][j] * sizes[i][j]);
            }
        }
        return ans;
    }
}
