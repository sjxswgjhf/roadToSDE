package Bloomberg2;

import java.util.HashSet;

public class lt694numDistinctIslands {

    class Solution {

        String[] arrow = {"R", "U", "L", "D"};
        int[][] dirs = {{0,1}, {-1, 0}, {0, -1}, {1,0}};
        // String path = "";
        public int numDistinctIslands(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            HashSet<String> set = new HashSet<>();
            boolean[][] visited = new boolean[m][n];
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(grid[i][j] == 1 && !visited[i][j]){
                        String path =  dfs(grid, i, j, m, n, visited);
                        set.add(path);
                    }
                }
            }
            return set.size();
        }

        private String dfs(int[][] grid, int r, int c, int m, int n, boolean[][] visited){
            visited[r][c] = true;
            String path = "1";
            for(int i = 0; i < 4; i++){
                int nr = dirs[i][0] + r;
                int nc = dirs[i][1] + c;
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc] && grid[nr][nc] == 1){
                    path += dfs(grid, nr, nc, m, n, visited);
                    path += arrow[i];
                }
            }
            return path;
        }
    }
}
