package binarysearch;

public class bs77makingChange {

/*
贪心找离n最近的25，10，5，1
 */
    class Solution {
        public int solve(int n) {
            if(n < 5){
                return n;
            }
            else if(n >= 5 && n < 10){
                return solve(n-5) + 1;
            }
            else if(n >= 10 && n < 25){
                int num = n / 10;
                return solve(n - 10 * num) + num;
            }
            else{
                int num = n / 25;
                return solve(n - num * 25) + num;
            }
        }
    }

    /*
        dp的O(n)会TLE
     */
    class SolutionTLE {
        public int solve(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 0;
            for(int i = 1; i <= n; i++){
                dp[i] = dp[i-1]+1;
                if(i >= 5){
                    dp[i] = Math.min(dp[i], dp[i - 5] + 1);
                }
                if(i >= 10){
                    dp[i] = Math.min(dp[i], dp[i - 10] + 1);
                }
                if(i >= 25){
                    dp[i] = Math.min(dp[i], dp[i - 25] + 1);
                }
            }
            return dp[n];
        }
    }
}
