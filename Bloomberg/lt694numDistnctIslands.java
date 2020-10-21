package Bloomberg;

import java.util.HashMap;
import java.util.HashSet;

public class lt694numDistnctIslands {
    class Solution {

        //up right down left
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        HashMap<Integer, String> map = new HashMap<>();
        String path = "";
        public int numDistinctIslands(int[][] grid) {
            if(grid == null || grid.length == 0){
                return 0;
            }
            map.put(0, "u");
            map.put(1, "r");
            map.put(2, "d");
            map.put(3, "l");
            HashSet<String> res = new HashSet<>();
            int m = grid.length;
            int n = grid[0].length;
            boolean[][] visited = new boolean[m][n];
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(grid[i][j] == 1 && !visited[i][j]){
                        dfs(grid, visited, i, j, m, n);
                        res.add(path);
                        path = "";
                    }
                }
            }
            return res.size();
        }

        private void dfs(int[][] grid, boolean[][] visited, int r, int c, int m, int n){
            visited[r][c] = true;
            path += "1";
            for(int i = 0; i < 4; i++){
                int nr = r + dirs[i][0];
                int nc = c + dirs[i][1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc] && grid[nr][nc] == 1){
                    dfs(grid, visited, nr, nc, m, n);
                    path += map.get(i);
                }
            }
        }
    }
}
