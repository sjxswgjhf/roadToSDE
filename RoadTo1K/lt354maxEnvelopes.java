package RoadTo1K;

import java.util.Arrays;

public class lt354maxEnvelopes {

    class Solution {
        /*
        dp[i]: 第i个信封能做多少个盒子取决于比他小的信封中最多的那个装了多少个盒子
        dp[i]: max(dp[0~j])
        所以我们要排序先,保证0~j的信封是小于i的宽度，高度是话需要额外判断
        */
        public int maxEnvelopes(int[][] envelopes) {
            if(envelopes == null || envelopes.length == 0){
                return 0;
            }
            Arrays.sort(envelopes, (a, b)->a[0]-b[0]);
            int n = envelopes.length;
            int[] dp = new int[n];
            int res = 0;
            for(int i = 0; i < n; i++){
                dp[i] = 1;
                for(int j = 0; j < i; j++){
                    //这里要保证之前信封是小于宽跟高的
                    if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                res = Math.max(res, dp[i]);
            }
            return res;
        }
    }


}
