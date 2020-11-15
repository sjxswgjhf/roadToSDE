package Bloomberg2;

public class lt79wordSearch {

    class Solution {
        public boolean exist(char[][] board, String word) {
            int m = board.length;
            int n = board[0].length;
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(board[i][j] == word.charAt(0)){
                        boolean[][] visited = new boolean[m][n];
                        if(dfs(board, word, 0, i, j , visited, m, n)){
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        int[][] dirs= {{0,1}, {-1, 0}, {0, -1}, {1,0}};
        private boolean dfs(char[][] board, String word, int idx, int r, int c, boolean[][] visited, int m, int n){
            if(idx == word.length() - 1){
                if(word.charAt(idx) == board[r][c]){
                    return true;
                }
                else{
                    return false;
                }
            }
            if(word.charAt(idx) != board[r][c]){
                return false;
            }
            visited[r][c] = true;
            for(int i = 0; i < 4; i++){
                int nr = r + dirs[i][0];
                int nc = c + dirs[i][1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]){
                    if(dfs(board, word, idx + 1, nr, nc, visited, m, n)){
                        return true;
                    }
                }
            }
            visited[r][c] = false;
            return false;
        }
    }
}
