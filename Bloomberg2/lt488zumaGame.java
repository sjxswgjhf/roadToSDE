package Bloomberg2;

public class lt488zumaGame {

    class Solution {
        /*
        bf就是每个位置都是试着塞手里的球，然后看能不能引爆吗，再塞入
        剪枝，塞入同样颜色的后面并且能引爆
        */
        public int findMinStep(String board, String hand) {
            int[] ballsCount = new int[26];
            for(char c : hand.toCharArray()){
                ballsCount[c-'A']++;
            }
            return dfs(board, ballsCount);
        }

        private int dfs(String board, int[] ballsCount){
            if(board.equals("") || board.length() == 0){
                return 0;
            }
            int res = Integer.MAX_VALUE;
            int i = 0;
            int j = 0;
            while(i < board.length()){
                //查看有没有多个连续的
                while(j < board.length() && board.charAt(i) == board.charAt(j)){
                    j++;
                }
                int color = (board.charAt(i) - 'A');
                //还需要几个球去构成3个连续的
                int ballsNeed = 3 - (j - i);
                if(ballsCount[color] >= ballsNeed){
                    //先去掉连续的球，然后再更新
                    String str = update(board.substring(0, i) + board.substring(j));
                    ballsCount[color] -= ballsNeed;
                    int next = dfs(str, ballsCount);
                    if(next >= 0){
                        res = Math.min(res, next);
                    }
                    ballsCount[color] += ballsNeed;
                }
                i = j;
            }
            return res == Integer.MAX_VALUE ? - 1 : res;
        }

        private String update(String str){
            int i = 0;
            while(i < str.length()){
                int j = i;
                while(j < str.length() && str.charAt(j) == str.charAt(i)){
                    j++;
                }
                if(j - i >= 3){
                    return update(str.substring(0, i) + str.substring(j));
                }else{
                    i++;
                }
            }
            return str;
        }

    }
}
