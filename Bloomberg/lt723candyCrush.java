package Bloomberg;

public class lt723candyCrush {

    class Solution {
        public int[][] candyCrush(int[][] board) {
            int m = board.length;
            int n = board[0].length;
            boolean find =  true;
            while(find){
                find = false;
                for(int i = 0; i < m; i++){
                    for(int j = 0; j < n; j++){
                        int val = Math.abs(board[i][j]);
                        //horizontial
                        if(val != 0 && j < n - 2 && val == Math.abs(board[i][j + 1]) && val == Math.abs(board[i][j + 2])){
                            find = true;
                            board[i][j] = -val;
                            board[i][j + 1] = -val;
                            board[i][j + 2] = -val;
                        }
                        if((val!= 0 && i < m -2 && val == Math.abs(board[i + 1][j])) && val == Math.abs(board[i + 2][j])){
                            find = true;
                            board[i][j] = -val;
                            board[i+1][j] = -val;
                            board[i+2][j] = -val;
                        }
                    }
                }


                //vertical drop
                for(int i = 0; i < n; i++){
                    int r = m - 1;
                    for(int j = m - 1; j >= 0; j--){
                        if(board[j][i] >= 0){
                            board[r][i] = board[j][i];
                            r--;
                        }
                    }
                    for(int j = r; j >= 0; j--){
                        board[j][i] = 0;
                    }
                }
            }
            return board;
        }
    }
}
