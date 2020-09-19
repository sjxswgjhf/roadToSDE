package facebook;

public class numDecodings {

    class Solution {
        /*
        case:
        122   1 2 2    12 2  1 22
        1224  1 2 2 4  1 22 4 12 2 4   12 24
        i = 4
        dp[i] = dp[i - 1]   4是一个单独的
        dp[i] += dp[i-2]    24是一个组合
        */
        public int numDecodings(String s) {
            int n = s.length();
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = s.charAt(0) == '0' ? 0 : 1;
            for(int i = 2; i <= n; i++){
                if(s.charAt(i - 1) != '0'){
                    dp[i] = dp[i - 1];
                }
                int val = Integer.valueOf(s.substring(i - 2, i));
                if(val >= 10 && val <= 26){
                    dp[i] += dp[i - 2];
                }

            }
            return dp[n];
        }
    }

}
