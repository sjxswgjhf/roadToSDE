package binarysearch;

public class bs23numberOfIslands {


    class Solution {
        public int solve(int[][] matrix) {
            if(matrix == null || matrix.length == 0){
                return 0;
            }
            int m = matrix.length;
            int n = matrix[0].length;
            int count = 0;
            boolean[][] visited = new boolean[m][n];
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(!visited[i][j] && matrix[i][j] == 1){
                        dfs(matrix, i, j, m, n, visited);
                        count++;
                    }
                }
            }
            return count;
        }

        private void dfs(int[][] matrix, int i, int j, int m, int n, boolean[][]visited){
            if(i < 0 || i >= m || j < 0 || j >= n){
                return;
            }
            if(matrix[i][j] == 0 || visited[i][j]){
                return;
            }
            visited[i][j] = true;
            dfs(matrix, i + 1, j, m, n, visited);
            dfs(matrix, i, j + 1, m, n, visited);
            dfs(matrix, i - 1, j, m, n, visited);
            dfs(matrix, i, j - 1, m, n, visited);
        }
    }
}
