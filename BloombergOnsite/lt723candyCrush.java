package BloombergOnsite;

public class lt723candyCrush {

    class Solution {
        /*
        对每个cell，往右看3跟往下看3，有一样的就设为负数
        然后变动整个board，进行下一轮
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
                    if(j < n - 2  &&(Math.abs(board[i][j]) ==  Math.abs(board[i][j + 1])) &&  (Math.abs(board[i][j + 1]) ==  Math.abs(board[i][j+2]))){
                        board[i][j] = -Math.abs(board[i][j]);
                        board[i][j+1] = -Math.abs(board[i][j]);
                        board[i][j+2] = -Math.abs(board[i][j]);
                        crushed = true;
                    }
                    if(i < m - 2 && (Math.abs(board[i][j]) == Math.abs(board[i + 1][j])) && (Math.abs(board[i+1][j]) == Math.abs(board[i+2][j]))){
                        board[i][j] = -Math.abs(board[i][j]);
                        board[i+1][j] = -Math.abs(board[i][j]);
                        board[i+2][j] = -Math.abs(board[i][j]);
                        crushed = true;
                    }
                }
            }
            if(!crushed){
                return board;
            }
            //vertically clean same candy
            for(int j = 0; j < n; j++){
                int rowIdx = m - 1;
                for(int i = m - 1; i >= 0; i--){
                    if(board[i][j] >= 0){
                        board[rowIdx][j] = board[i][j];
                        rowIdx--;
                    }
                }
                while(rowIdx >= 0){
                    board[rowIdx][j] = 0;
                    rowIdx--;
                }
            }
            return candyCrush(board);
        }
    }
}
