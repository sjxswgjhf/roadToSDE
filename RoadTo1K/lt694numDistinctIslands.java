package RoadTo1K;

import java.util.HashSet;

public class lt694numDistinctIslands {

    class Solution2 {

        String[] arrows = {"U", "R", "D","L"};
        int[][] dirs = {{-1,0}, {0,1}, {1, 0}, {0, -1}};
        public int numDistinctIslands(int[][] grid) {
            if(grid == null || grid.length == 0){
                return 0;
            }
            int m = grid.length;
            int n = grid[0].length;
            boolean[][] visited = new boolean[m][n];
            HashSet<String> set = new HashSet<>();
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(grid[i][j] == 1 && !visited[i][j]){
                        StringBuffer sb = new StringBuffer();
                        dfs(grid, i, j, m, n, visited, new StringBuffer());
                        System.out.println(sb);
                        set.add(sb.toString());
                    }
                }
            }

            return set.size();
        }


        private void dfs(int[][] grid, int r, int c, int m, int n, boolean[][] visited, StringBuffer sb){
            sb.append(grid[r][c]);
            visited[r][c] = true;
            for(int i = 0; i < 4; i++) {
                int nr = r + dirs[i][0];
                int nc = c + dirs[i][1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1 && !visited[nr][nc]) {
                    dfs(grid, nr, nc, m, n, visited, sb);
                    sb.append(arrows[i]);
                }
            }
        }
    }
    class Solution {

        String[] arrows = {"U", "R", "D","L"};
        int[][] dirs = {{-1,0}, {0,1}, {1, 0}, {0, -1}};
        public int numDistinctIslands(int[][] grid) {
            if(grid == null || grid.length == 0){
                return 0;
            }
            int m = grid.length;
            int n = grid[0].length;
            boolean[][] visited = new boolean[m][n];
            HashSet<String> set = new HashSet<>();
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(grid[i][j] == 1 && !visited[i][j]){
                        String path = dfs(grid, i, j, m, n, visited);
                        set.add(path);
                    }
                }
            }

            return set.size();
        }


        private String dfs(int[][] grid, int r, int c, int m, int n, boolean[][] visited){
            String res = "1";
            visited[r][c] = true;
            for(int i = 0; i < 4; i++){
                int nr = r + dirs[i][0];
                int nc = c + dirs[i][1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1 && !visited[nr][nc]){
                    res += dfs(grid, nr, nc, m, n, visited);
                    res += arrows[i];
                }
            }
            return res;
        }
    }
}
