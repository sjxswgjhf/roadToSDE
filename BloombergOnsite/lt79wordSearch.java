package BloombergOnsite;

public class lt79wordSearch {

    class Solution {
        public boolean exist(char[][] board, String word) {
            int m = board.length;
            int n = board[0].length;
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(board[i][j] == word.charAt(0)){
                        boolean[][] visited = new boolean[m][n];
                        if(dfs(board, word, i, j, 0, m, n, visited)){
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        int[][] dirs = {{1,0}, {0, 1}, {-1, 0}, {0, -1}};
        private boolean dfs(char[][] board, String word, int i, int j, int idx, int m, int n, boolean[][] visited){
            if(idx == word.length() - 1){
                if(board[i][j] == word.charAt(idx)){
                    return true;
                }else{
                    return false;
                }
            }
            if(word.charAt(idx) != board[i][j]){
                return false;
            }
            visited[i][j] = true;
            for(int d = 0; d < 4; d++){
                int nextR = i + dirs[d][0];
                int nextC = j + dirs[d][1];
                if(nextR >= 0 && nextR < m && nextC >= 0 && nextC < n && !visited[nextR][nextC]){
                    if(dfs(board, word, nextR, nextC, idx + 1, m, n, visited)){
                        return true;
                    }
                }
            }
            visited[i][j] = false;
            return false;
        }
    }
}
