package Bloomberg;

public class candyCrush {

    /*
    因为candy crush只有正值，所以我们在遍历的时候如果有能消除的就变成负值，检查的时候用abs来看，三个三个一看。把所有能消除的标记成负值，
    然后再drop，drop是vertical的，col by col，从底部往上走，如果当前cell不是负值的话就往下替换，走完之后负值都在上面了把剩下的全部替换成0
     */
    class Solution {
        public int[][] candyCrush(int[][] board) {
            int m = board.length, n = board[0].length;
            boolean redo = false;
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++)
                {
                    int val = Math.abs(board[i][j]);
                    if(val != 0 && j < n - 2 && Math.abs(board[i][j+1]) == val &&  Math.abs(board[i][j+2]) == val){
                        redo = true;
                        board[i][j] = board[i][j + 1] = board[i][j + 2] = -val;
                    }
                }
            }
            for(int i = 0 ; i < m ; i++){
                for(int j = 0; j < n; j++){
                    int val = Math.abs(board[i][j]);
                    if(val != 0 && i < m - 2 && Math.abs(board[i + 1][j]) == val && Math.abs(board[i + 2][j]) == val){
                        redo = true;
                        board[i][j] = board[i + 1][j] = board[i + 2][j] = -val;
                    }
                }
            }

            //drop vertical
            for(int j = 0; j < n; j++){
                int r = m - 1;
                for(int i = m - 1; i >= 0; i--){
                    if(board[i][j] >= 0){
                        board[r][j] = board[i][j];
                        r--;
                    }
                }
                for(int i = r; i >= 0; i--){
                    board[i][j] = 0;
                }
            }
            return redo ? candyCrush(board) : board;
        }
    }
}
