package Bloomberg;

public class lt529updateBoard {
    /*
    这题没有自己写， 实在看题目意思看累了。
    概括下就是点击的是炸弹的话就变成x，返回
    不是的话就看这个格子附近有没有炸弹，有炸弹的话，就看周边8格有几个炸弹，数完之后更新完了就返回，
    如果周边没炸弹，是个B的话，当前先更新成B，然后双重循环recursion更新周边8个，这题不需要去用额外的visited数组去维护，因为我们更新标记
    为E的格子，别的不更新，到最后所有E都会消失
     */

    class Solution {
        public char[][] updateBoard(char[][] board, int[] click) {
            int m = board.length;
            int n = board[0].length;
            int x = click[0];
            int y = click[1];
            if(board[x][y] == 'M'){
                board[x][y] = 'X';
                return board;
            }
            else{
                int count = 0;
                for(int i = -1; i < 2; i++){
                    for(int j = -1; j < 2; j++){
                        if(i == 0 && j == 0){
                            continue;
                        }
                        int row = x + i, col = y + j;
                        if(row < 0 || row >= m || col < 0 || col >=n){
                            continue;
                        }
                        if(board[row][col] == 'M' || board[row][col] == 'X'){
                            count++;
                        }
                    }
                }
                if(count > 0){
                    board[x][y] = (char)(count + '0');
                }else{
                    board[x][y] = 'B';
                    for(int i = -1; i < 2; i++){
                        for(int j = -1; j < 2; j++){
                            if(i == 0 && j == 0){
                                continue;
                            }
                            int row = x + i, col = y + j;
                            if(row < 0 || row >= m || col < 0 || col >=n){
                                continue;
                            }
                            if(board[row][col] == 'E'){
                                updateBoard(board, new int[]{row, col});
                            }
                        }
                    }
                }
            }

            return board;
        }
    }
}
