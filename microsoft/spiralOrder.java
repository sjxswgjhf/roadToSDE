package microsoft;

import java.util.ArrayList;
import java.util.List;

public class spiralOrder {
    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> res = new ArrayList<>();
            if(matrix.length == 0){
                return res;
            }
            int m = matrix.length;
            int n = matrix[0].length;
            boolean[][] seen = new boolean[m][n];
            //spiral的方向
            int[] dr = {0, 1, 0, -1};
            int[] dc = {1, 0, -1, 0};
            //起始位置跟方向
            int r = 0, c = 0, di = 0;
            for(int i = 0; i < m * n; i++){
                res.add(matrix[r][c]);
                seen[r][c] = true;
                //根据方向计算下一格
                int cr = r + dr[di];
                int cc = c + dc[di];
                //当任一超过边界或者已经走过就需要换方向
                if(0 <= cr && cr < m && 0 <= cc && cc < n && !seen[cr][cc]){
                    r = cr;
                    c = cc;
                }else{
                    //更新方向，计算新的r跟c
                    di = (di + 1) % 4;
                    r += dr[di];
                    c += dc[di];
                }
            }
            return res;
        }
    }
}
