package Bloomberg;

public class numIslands {

    class Solution {
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
                    if(!visited[i][j] && grid[i][j] == '1'){
                        helper(grid, visited, i, j, m, n);
                        ans++;
                    }
                }
            }
            return ans;
        }

        private void helper(char[][] grid, boolean[][] visited, int r, int c, int m, int n){
            if(r < 0 || r >= m || c < 0 || c >= n || visited[r][c]){
                return;
            }
            if(grid[r][c] == '0'){
                return;
            }
            visited[r][c] = true;
            helper(grid, visited, r + 1, c , m , n);
            helper(grid, visited, r - 1, c , m , n);
            helper(grid, visited, r, c + 1 , m , n);
            helper(grid, visited, r, c - 1 , m , n);
        }
    }
}
