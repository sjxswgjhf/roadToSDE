package Bloomberg;

public class lt91numDecodings {

    class Solution {

        /*
        单独是一个解，如果跟前面那个合起来范围是10~24的话是另一种解，如果是0只能跟前面合起来

        */
        public int numDecodings(String s) {
            if(s == null || s.length() == 0){
                return 0;
            }
            int n = s.length();
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = s.charAt(0) == '0' ? 0 : 1;
            for(int i = 2; i <= n; i++){
                //按这种的处理方法可以避免中间是多个0的问题，如果是按前面是0单独处理比较麻烦,需要判断前面的是不是00，是的话设置成0
                if(s.charAt(i - 1) != '0'){
                    dp[i] = dp[i-1];
                }
                //这样直接处理了10011这种情况。上面的if把1011
                int val = Integer.valueOf(s.substring(i-2, i));
                if(val >= 10 && val <= 26){
                    dp[i] += dp[i - 2];
                }
            }
            return dp[n];
        }
    }
}
