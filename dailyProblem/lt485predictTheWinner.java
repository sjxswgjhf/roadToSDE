package dailyProblem;

public class lt485predictTheWinner {

    class SolutionTD {
        public boolean PredictTheWinner(int[] nums) {
            int[][] memo = new int[nums.length][nums.length];
            return winner(nums, 0, nums.length - 1, memo) >= 0;
        }

        public int winner(int[] nums, int s, int e, int[][] memo){
            if(s == e){
                return nums[s];
            }
            if(memo[s][e] != 0){
                return memo[s][e];
            }
            int a = nums[s] - winner(nums, s + 1, e, memo);
            int b = nums[e] - winner(nums, s, e - 1, memo);
            memo[s][e] = Math.max(a, b);
            return memo[s][e];
        }

    }

    class SolutionBU {

        public boolean PredictTheWinner(int[] nums) {
            int[][] dp = new int[nums.length][nums.length];
            for(int i = 0; i < nums.length; i++){
                dp[i][i] = nums[i];
            }
            //为什么不能正着写，因为我们最后要计算0~n，那么正着写最后计算的是n-1~n，没有计算到0~n，所以要反着来
            //这个loop里面有个问题没解决就是dp[i][i]的情况没被cover，所以这个需要特殊处理先
            for(int s = nums.length - 1; s >= 0; s--){
                // dp[s][s] = nums[s];
                for(int e = s + 1; e < nums.length; e++){
                    int f = nums[s] - dp[s+1][e];
                    int n = nums[e] - dp[s][e -1];
                    dp[s][e] = Math.max(f, n);
                }
            }
            return dp[0][nums.length - 1] >= 0;
        }
    }
}
