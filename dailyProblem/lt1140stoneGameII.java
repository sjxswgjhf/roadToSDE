package dailyProblem;

public class lt1140stoneGameII {
    class Solution {
        /*
        end with the most stones

        M = max(M,x)
        X = 1 ~ 2M


        */
        public int stoneGameII(int[] piles) {
            int n = piles.length;
            int[] sums = new int[piles.length];
            sums[n - 1] = piles[n - 1];
            for(int i = n - 2; i >= 0; i--){
                sums[i] = sums[i+1]+piles[i];
            }
            int[][] memo = new int[n][n];
            return helper(piles, memo, sums, 0, 1);
        }

        //以idx开始，能选m个
        private int helper(int[] piles, int[][] memo, int[] sums, int idx, int m){
            if(idx == piles.length){
                return 0;
            }
            //如果剩下的都能选走，直接选走
            if(2*m >= piles.length - idx){
                return sums[idx];
            }

            if(memo[idx][m] != 0){
                return memo[idx][m];
            }
            int res = Integer.MAX_VALUE;
            for(int i = 1; i <= 2 * m; i++){
                //对手能在当前从我选完之后得到的最小的收益
                res = Math.min(res, helper(piles, memo, sums, idx + i, Math.max(i, m)));
            }
            //我的收益是总得当前剩下的sum - 对手的最小收益
            memo[idx][m] = sums[idx] - res;
            return memo[idx][m];
        }
    }
}
