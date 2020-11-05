package Bloomberg;

public class lt79wordExist {

    class Solution {
        public boolean exist(char[][] board, String word) {

            int m = board.length;
            int n = board[0].length;

            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(board[i][j] == word.charAt(0)){
                        boolean[][] visited = new boolean[m][n];
                        if(dfs(board, i, j, m, n, word, 0, visited)){
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        int[][] dirs = {{0,1}, {-1,0}, {0, -1}, {1,0}};
        private boolean dfs(char[][] board, int r, int c, int m, int n, String word, int idx, boolean[][] visited){
            if(idx >= word.length()){
                return false;
            }
            if(board[r][c] != word.charAt(idx)){
                return false;
            }
            if(idx == word.length() - 1 && board[r][c] == word.charAt(idx)){
                return true;
            }
            visited[r][c] = true;
            for(int i = 0; i < dirs.length; i++){
                int nr = r + dirs[i][0];
                int nc = c + dirs[i][1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]){
                    if(dfs(board, nr, nc, m, n, word, idx + 1, visited)){
                        return true;
                    }
                }
            }
            visited[r][c] = false;
            return false;
        }
    }

}
