package facebook;

public class numIslands {

    class Solution {
        int[][] dirs = {{1,0}, {0, -1}, {-1, 0}, {0, 1}};
        public int numIslands(char[][] grid) {
            if(grid == null || grid.length == 0){
                return 0;
            }
            int m = grid.length;
            int n = grid[0].length;
            int ans = 0;
            boolean[][] visited = new boolean[m][n];
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(grid[i][j] == '1' && !visited[i][j]){
                        helper(grid, i, j, m, n, visited);
                        ans++;
                    }
                }
            }
            return ans;
        }

        private void helper(char[][] grid, int r, int c, int m, int n, boolean[][] visited){
            if(grid[r][c] == '0'){
                return;
            }
            visited[r][c] = true;
            for(int i = 0; i < 4; i++){
                int nr = r + dirs[i][0];
                int nc = c + dirs[i][1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]){
                    helper(grid, nr, nc, m, n, visited);
                }
            }
        }
    }

}
