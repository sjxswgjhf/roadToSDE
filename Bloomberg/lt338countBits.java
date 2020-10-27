package Bloomberg;

public class lt338countBits {

    class Solution {
        /*

        0 0
        1 1
        2 1
        3 1+1=2
        4 1
        5 1 + 1
        6 4 + 2 =2
        7 4 + 3 = 3
        找最近的2的倍数的值，然后看剩下的
        */
        public int[] countBits(int num) {
            if(num == 0){
                int[] res = new int[1];
                res[0] = 0;
                return res;
            }
            int[] dp = new int[num + 1];
            dp[0] = 0;
            dp[1] = 1;
            for(int i = 2; i <= num; i++){
                int base = (int)(Math.log(i) / Math.log(2));
                int pow2 = (int)Math.pow(2, base);
                int remainder = i - pow2;
                if(remainder == 0){
                    dp[i] = 1;
                }else{
                    dp[i] = dp[remainder] + dp[pow2];
                }
            }
            return dp;
        }
    }
}
