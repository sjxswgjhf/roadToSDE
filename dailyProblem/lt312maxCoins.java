package dailyProblem;

public class lt312maxCoins {

    class Solution {
        /*
        i~k~j
         我打包第k个气球的时候左右是i跟j，我先打爆所有i~k的气球的收益，跟k~j所有气球的收益
         那我收益是dp[i][k] + a[i]*a[k]*[j] + dp[k][j]
        */
        public int maxCoins(int[] nums) {
            int n = nums.length + 2;
            int[] tmp = new int[n];
            tmp[0] = 1;
            tmp[n - 1] =1;
            for(int i = 0; i < nums.length; i++){
                tmp[i + 1] = nums[i];
            }
            int[][] memo = new int[n][n];
            return getMax(tmp, memo, 0, n - 1);
        }

        private int getMax(int[] nums, int[][] memo, int s, int e){
            if(s + 1 == e){
                return 0;
            }
            if(memo[s][e] > 0){
                return memo[s][e];
            }
            int max = 0;
            for(int k = s + 1; k < e; k++){
                max = Math.max(max, getMax(nums, memo, s, k) + getMax(nums, memo, k, e) + nums[s]*nums[k]*nums[e]);
            }
            memo[s][e] = max;
            return memo[s][e];
        }
    }
}
