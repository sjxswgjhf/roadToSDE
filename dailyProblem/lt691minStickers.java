package dailyProblem;

import java.util.Arrays;

public class lt691minStickers {

    class Solution {
        public int minStickers(String[] stickers, String target) {
            int n = target.length();
            int N = (1 << n);
            int[] dp = new int[N];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for(int i = 0; i < N; i++){
                //之前的状态达不到的当前的状态
                if(dp[i] == Integer.MAX_VALUE){
                    continue;
                }
                for(String str : stickers){
                    //从i的状态到j的状态, i 小 j 大
                    int j = findNextStatus(i, str, target);
                    dp[j] = Math.min(dp[j], dp[i] + 1);
                }

            }

            return dp[N - 1] == Integer.MAX_VALUE ? -1 : dp[N - 1];
        }

        private int findNextStatus(int status, String str, String target){
            for(char c : str.toCharArray()){
                for(int k = 0; k < target.length(); k++){
                    //bitmask的第k为是0并且str跟target当前的idx的char一样
                    if(((status >> k) & 1) == 0 && target.charAt(k) == c){
                        //更新第k位
                        status += (1 << k);
                        break;
                    }
                }
            }
            return status;
        }
    }
}
