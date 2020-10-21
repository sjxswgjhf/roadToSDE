package Bloomberg;

public class lt695maxAreaOfIsland {

    class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            if(grid == null || grid.length == 0){
                return 0;
            }
            int max = 0;
            int m = grid.length;
            int n = grid[0].length;
            boolean[][] visited = new boolean[m][n];
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(grid[i][j] == 1 && !visited[i][j]){
                        int cur = dfs(grid, visited, i, j, m, n);
                        max = Math.max(cur, max);
                    }
                }
            }
            return max;
        }

        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        private int dfs(int[][] grid, boolean[][] visited, int r, int c, int m, int n){
            visited[r][c] = true;
            int cur = 1;
            for(int i = 0; i < 4; i++){
                int nr = r + dirs[i][0];
                int nc = c + dirs[i][1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc] && grid[nr][nc] == 1){
                    cur += dfs(grid, visited, nr, nc, m, n);
                }
            }
            return cur;
        }
    }

}
