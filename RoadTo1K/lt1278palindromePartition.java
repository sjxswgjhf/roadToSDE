package RoadTo1K;

import java.util.Arrays;

public class lt1278palindromePartition {

    class Solution {
        /*
        dp[i][k]:

        0~i分成了k-1组 palin，如果我要把i+1~n变成最后一组的话我最少要改几个

        min cost to make palin
        */
        public int palindromePartition(String s, int K) {
            int n = s.length();
            if(n == K){
                return 0;
            }
            int[][] dp = new int[K + 1][n];
            for(int i = 0; i <= K; i++){
                Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
            }
            for(int i = 0; i < n; i++){
                dp[1][i] = minCostMakePalin(s.substring(0, i + 1));
            }

            for(int k = 2; k <= K; k++){
                //如果想要分成k组的话，起码要k个char，即idx起码k-1
                for(int i = k - 1; i < n; i++){
                    //然后dp[k][i]要么是已经求过的最小，要么是在j处分割成k-1，j + 跟j+1~i最后一组的cost
                    /*

                    这个写法有问题，但是是对的，因为我们base case处理的时候把所有情况都变成了MAX先，
                    那么当j小于k的时候，虽然是无效的，但是也是max的值，不应该这样写，
                    如果要保证j之前分成k-1组那么j肯定要大于等于k-2idx的，不然没法分成k-1组，然后
                    for(int j = 0; j < i; j++){
                        dp[k][i] = Math.min(dp[k][i], dp[k-1][j] +  minCostMakePalin(s.substring(j + 1, i + 1)));
                    }
                    */
                    //这种可以
                    for(int j = k-2; j < i; j++){
                        dp[k][i] = Math.min(dp[k][i], dp[k-1][j] +  minCostMakePalin(s.substring(j + 1, i + 1)));
                    }
                    //这种也可以
                    for(int j = i - 1; j >= 0 && j >= k - 2; j--){
                        dp[k][i] = Math.min(dp[k][i], dp[k-1][j] +  minCostMakePalin(s.substring(j + 1, i + 1)));
                    }
                }
            }
            return dp[K][n-1];
        }

        private int minCostMakePalin(String s){
            int l = 0;
            int r = s.length() - 1;
            int cost = 0;
            while(l < r){
                if(s.charAt(l) == s.charAt(r)){
                    l++;
                    r--;
                }else{
                    cost++;
                    l++;
                    r--;
                }
            }
            return cost;
        }

    }


}
