package dailyProblem;

public class lt1406stoneGameIII {
    class Solution {
        public String stoneGameIII(int[] stoneValue) {
            int n = stoneValue.length;
            int[] memo = new int[n];
            int res = canwin(stoneValue, memo, 0);
            if(res < 0){
                return "Alice";
            }
            else if(res == 0){
                return "Tie";
            }
            else{
                return "Bob";
            }
        }

        private int canwin(int[] stoneValue, int[] memo, int idx){
            if(idx >= stoneValue.length){
                return 0;
            }
            if(memo[idx] != 0){
                return memo[idx];
            }
            memo[idx] = Integer.MAX_VALUE;
            int score = 0;
            //选1~3个石头,三种不同的分数为累积分数-减去对手的分数
            for(int i = idx; i <= Math.min(idx + 3, stoneValue.length); i++){
                score += stoneValue[i];
                memo[idx] = Math.min(memo[idx], score - canwin(stoneValue, memo, i + 1));

            }
            return memo[idx];
        }

    }
}
