package Bloomberg;

import java.util.ArrayList;
import java.util.List;

public class spiralOrder {
    class Solution {
        /*
        right down left up
        每到临界点或者访问过的地方就换方向
        */
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> res = new ArrayList();
            if(matrix == null || matrix.length == 0){
                return res;
            }
            int m = matrix.length;
            int n = matrix[0].length;
            int[] dirR = {0, 1, 0, -1};
            int[] dirC = {1, 0, -1, 0};
            //每当我们遇到了访问过的或者超界了就要变方向
            boolean[][] seen = new boolean[m][n];
            int r = 0;
            int c = 0;
            int idx = 0;
            for(int i = 0; i < m * n; i++){
                res.add(matrix[r][c]);
                seen[r][c] = true;
                int nr = r + dirR[idx];
                int nc = c + dirC[idx];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && !seen[nr][nc]){
                    r = nr;
                    c = nc;
                }else{
                    idx = (idx + 1) % 4;
                    r += dirR[idx];
                    c += dirC[idx];
                }
            }
            return res;
        }
    }
}
