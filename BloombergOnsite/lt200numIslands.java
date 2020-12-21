package BloombergOnsite;

public class lt200numIslands {

    class Solution {

        public int numIslands(char[][] grid) {
            int count = 0;
            int m = grid.length;
            int n = grid[0].length;
            boolean[][] visited = new boolean[m][n];
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(grid[i][j] == '1' && !visited[i][j]){
                        count++;
                        dfs(grid, i, j, m, n, visited);
                    }
                }
            }
            return count;
        }

        private void dfs(char[][] grid, int i, int j, int m, int n, boolean[][] visited){
            if(i < 0 || i >= m || j < 0 || j >= n){
                return;
            }
            if(visited[i][j]){
                return;
            }
            if(grid[i][j] == '0'){
                return;
            }
            visited[i][j] = true;
            dfs(grid, i - 1, j, m, n, visited);
            dfs(grid, i + 1, j, m, n, visited);
            dfs(grid, i, j - 1, m, n, visited);
            dfs(grid, i, j + 1, m, n, visited);

        }

    }
}
