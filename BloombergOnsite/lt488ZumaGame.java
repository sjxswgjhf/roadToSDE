package BloombergOnsite;

public class lt488ZumaGame {

    class Solution {
        /*
        整个逻辑：
        先看手里各种颜色的球各有多少个，然后backtrack board
        首先我们从头开始，算有多少颜色一样的连在一样，如果我们手里的+board里面的能大于等于三，我们就试着消除这个然后继续后面的，
        先更新substring，然后把新的substring要再更新，因为去掉了这段球之后，新的board可以自己可以组合成长度大于等于3的同颜色球的baord，
        也要去掉，然后减掉手里的球的数量，然后backtrack新的board跟手里的球数，返回值跟res取min,觉得注意下返回的不能是-1才能取min，然后复原手里球的数量，然后用j更新i的position，
        最后看res是不是max，是max就表示做不到，返回-1,不然就返回min
        */
        public int findMinStep(String board, String hand) {
            int[] count = new int[26];
            for(char c : hand.toCharArray()){
                count[c-'A']++;
            }
            return dfs(board, count);
        }

        private int dfs(String board, int[] count){
            if(board.length() == 0){
                return 0;
            }
            int res = Integer.MAX_VALUE;
            int i = 0;
            int j = 0;
            while(i < board.length()){
                //count the number of same color balls
                while(j < board.length() && board.charAt(i) == board.charAt(j)){
                    j++;
                }
                //需要的颜色
                int color = board.charAt(i) - 'A';
                //这里的j是已经错位了的
                // int ballsNeed = Math.max(0, 3 - (j - i));
                int ballsNeed = 3 - (j-i);
                if(count[color] >= ballsNeed){
                    //new string formed
                    String str = update(board.substring(0, i) + board.substring(j));
                    //ball in hands left
                    count[color] -= ballsNeed;
                    int next = dfs(str, count);
                    if(next >= 0){
                        res = Math.min(res, next + ballsNeed);
                    }
                    count[color] += ballsNeed;
                }
                //update i to j position
                i = j;
            }
            return res == Integer.MAX_VALUE ? -1 : res;
        }

        private String update(String board){
            int i = 0;
            while(i < board.length()){
                int j = i;
                while(j < board.length() && board.charAt(i) == board.charAt(j)){
                    j++;
                }
                if(j - i >= 3){
                    board = board.substring(0, i) + board.substring(j);
                    i = 0;
                }else{
                    i++;
                }
            }
            return board;
        }
    }

}
