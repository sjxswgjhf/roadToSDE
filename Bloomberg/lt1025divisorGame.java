package Bloomberg;

public class lt1025divisorGame {

    class Solution {
        public boolean divisorGame(int N) {
            boolean[] dp = new boolean[N + 1];
            for(int i = 1 ; i <= N; i++){
                for(int x = 1; x < i; x++){
                    if(i % x == 0 && !dp[i - x]){
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[N];
        }
    }
    class SolutionTLE {
        public boolean divisorGame(int N) {
            if(N == 1){
                return false;
            }
            if(N == 2){
                return true;
            }
            for(int i = 1; i < N; i++){
                if(N % i == 0){
                    if(!divisorGame(N - i)){
                        return true;
                    }
                }
            }
            return false;
        }
    }



/*
3 - 1 = 2 - 1 = 1
*/
}
