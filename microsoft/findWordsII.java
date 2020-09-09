package microsoft;

import java.util.ArrayList;
import java.util.List;

public class findWordsII {

    class SolutionTrier {
        public List<String> findWords(char[][] board, String[] words) {
            List<String> res = new ArrayList<>();
            TrieNode root = buildTrie(words);
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    dfs (board, i, j, root, res);
                }
            }
            return res;
        }

        public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
            char c = board[i][j];
            if (c == '#' || p.next[c - 'a'] == null) return;
            p = p.next[c - 'a'];
            if (p.word != null) {   // found one
                res.add(p.word);
                p.word = null;     // de-duplicate
            }

            board[i][j] = '#';
            if (i > 0) dfs(board, i - 1, j ,p, res);
            if (j > 0) dfs(board, i, j - 1, p, res);
            if (i < board.length - 1) dfs(board, i + 1, j, p, res);
            if (j < board[0].length - 1) dfs(board, i, j + 1, p, res);
            board[i][j] = c;
        }

        public TrieNode buildTrie(String[] words) {
            TrieNode root = new TrieNode();
            for (String w : words) {
                TrieNode p = root;
                for (char c : w.toCharArray()) {
                    int i = c - 'a';
                    if (p.next[i] == null) p.next[i] = new TrieNode();
                    p = p.next[i];
                }
                p.word = w;
            }
            return root;
        }

        class TrieNode {
            TrieNode[] next = new TrieNode[26];
            String word;
        }
    }

    class SolutionSolower {

        int[][] dirs = {{-1,0},{0, 1}, {1, 0},{0, -1}};

        public List<String> findWords(char[][] board, String[] words) {
            List<String> res = new ArrayList<>();
            if(words == null || words.length == 0){
                return res;
            }
            int m = board.length;
            int n = board[0].length;
            for(String word : words){
                outer: for(int i = 0; i < m; i++){
                    for(int j = 0; j < n; j++){
                        if(board[i][j] == word.charAt(0)){
                            boolean[][] visited = new boolean[m][n];
                            if(helper(word, board, visited, m, n, i, j, 0)){
                                res.add(word);
                                break outer;
                            }
                        }
                    }
                }
            }
            return res;
        }

        private boolean helper(String word,char[][] board, boolean[][] visited, int m, int n, int r, int c, int idx){
            if(idx >= word.length() || visited[r][c]){
                return false;
            }
            if(word.charAt(idx) != board[r][c]){
                return false;
            }
            if(idx == word.length()-1 && word.charAt(idx) == board[r][c]){
                return true;
            }
            visited[r][c] = true;
            for(int i = 0 ; i < 4; i++){
                int nr = r + dirs[i][0];
                int nc = c + dirs[i][1];
                if(nr >= 0 && nc >= 0 && nr < m && nc < n){
                    if(helper(word, board, visited, m, n, nr, nc, idx + 1)){
                        return true;
                    }
                }
            }
            visited[r][c] = false;
            return false;
        }

    }
}
