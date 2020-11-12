package Bloomberg2;

public class lt723candyCrush {

    class Solution {
        /*
        查看横着三个跟竖着三个是不是一样，是的话标记成负值，最后消除
        1.查看的时候注意越界,这里一定不可以用m-2跟n-2在for loop里面，会少一些边界判断，只能加在if里面
        2.消除的时候我column by column

        */
        public int[][] candyCrush(int[][] board) {
            int m = board.length;
            int n = board[0].length;
            boolean crushed = false;
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(board[i][j] == 0){
                        continue;
                    }
                    if((j < n - 2 && Math.abs(board[i][j]) == Math.abs(board[i][j + 1])) && (Math.abs(board[i][j]) == Math.abs(board[i][j + 2]))){
                        crushed = true;
                        board[i][j] = -Math.abs(board[i][j]);
                        board[i][j + 1] = -Math.abs(board[i][j + 1]);
                        board[i][j + 2] = -Math.abs(board[i][j + 2]);
                    }
                    if((i < m - 2 && Math.abs(board[i][j]) == Math.abs(board[i + 1][j])) && (Math.abs(board[i][j]) == Math.abs(board[i + 2][j]))){
                        crushed = true;
                        board[i][j] = -Math.abs(board[i][j]);
                        board[i + 1][j] = -Math.abs(board[i + 1][j]);
                        board[i + 2][j] = -Math.abs(board[i + 2][j]);
                    }
                }
            }
            if(crushed == false){
                return board;
            }else{
                //clean column by column
                for(int i = 0; i < n; i++){
                    int idx = m - 1;
                    for(int j = m - 1; j >= 0; j--){
                        if(board[j][i] >= 0){
                            board[idx][i] = board[j][i];
                            idx--;
                        }
                    }
                    for(int j = idx; j >= 0; j--){
                        board[j][i] = 0;
                    }
                }
                return candyCrush(board);
            }
        }
    }
}
