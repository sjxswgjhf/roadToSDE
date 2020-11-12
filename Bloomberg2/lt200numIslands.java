package Bloomberg2;

public class lt200numIslands {

    class Solution {
        public int numIslands(char[][] grid) {
            if(grid == null || grid.length == 0){
                return 0;
            }
            int count = 0;
            int m = grid.length;
            int n = grid[0].length;
            boolean[][] visited = new boolean[m][n];
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    //记得一定要加visited的判断避免重复计算
                    if(grid[i][j] == '1' && !visited[i][j]){
                        dfs(grid,i ,j, m, n, visited);
                        count++;
                    }
                }
            }
            return count;
        }

        private void dfs(char[][] grid, int r, int c, int m, int n, boolean[][] visited){
            if(r < 0 || r >= m || c < 0 || c >= n){
                return;
            }
            if(visited[r][c]){
                return;
            }
            if(grid[r][c] == '0'){
                return;
            }
            visited[r][c] = true;
            dfs(grid, r + 1, c, m, n, visited);
            dfs(grid, r, c + 1, m , n, visited);
            dfs(grid, r - 1, c, m , n, visited);
            dfs(grid, r, c - 1, m , n, visited);
        }
    }
}
