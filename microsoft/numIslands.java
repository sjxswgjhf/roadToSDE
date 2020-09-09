package microsoft;

public class numIslands {

    class Solution {
        int[][] dirs = {{-1,0}, {0, 1}, {1,0}, {0, -1}};
        public int numIslands(char[][] grid) {
            if(grid == null || grid.length == 0){
                return 0;
            }
            int m = grid.length;
            int n = grid[0].length;
            boolean[][] visited = new boolean[m][n];
            int res = 0;
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(grid[i][j] == '1' && !visited[i][j]){
                        helper(grid, visited, m, n, i, j);
                        res++;
                    }
                }
            }
            return res;
        }

        private void helper(char[][] grid, boolean[][] visited, int m, int n, int r, int c){
            if(grid[r][c] == '0'){
                return;
            }
            visited[r][c] = true;
            for(int i = 0; i < 4; i++){
                int nr = r + dirs[i][0];
                int nc = c + dirs[i][1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n){
                    if(!visited[nr][nc]){
                        helper(grid, visited, m, n, nr, nc);
                    }
                }
            }
        }
    }
}
