package Bloomberg;

import java.util.ArrayList;
import java.util.List;

public class lt54spiralOrder {
    class Solution {
        /*
        direction：左下右上
        */
        public List<Integer> spiralOrder(int[][] matrix) {
            if(matrix == null || matrix.length == 0){
                return new ArrayList<>();
            }
            int m = matrix.length;
            int n = matrix[0].length;
            int[][] dirs = {{0,1}, {1,0}, {0, -1}, {-1,0}};
            int idx = 0;
            boolean[][] visited = new boolean[m][n];
            List<Integer> res = new ArrayList<>();
            int r = 0;
            int c = 0;
            for(int i = 0; i < m * n; i++){
                res.add(matrix[r][c]);
                visited[r][c] = true;
                int nr = r + dirs[idx][0];
                int nc = c + dirs[idx][1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]){
                    r = nr;
                    c = nc;
                }else{
                    idx = (idx + 1) % 4;
                    r = r + dirs[idx][0];
                    c = c + dirs[idx][1];
                }
            }
            return res;
        }
    }
}
