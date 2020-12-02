package RoadTo1K;

import java.util.Arrays;

public class lt132minCut {

    class SolutionBest {
        public int minCut(String s) {
            char[] c = s.toCharArray();
            int n = c.length;
            int[] cut = new int[n];
            boolean[][] pal = new boolean[n][n];

            for(int i = 0; i < n; i++) {
                int min = i;
                for(int j = 0; j <= i; j++) {
                    if(c[j] == c[i] && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
                        pal[j][i] = true;
                        min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
                    }
                }
                cut[i] = min;
            }
            return cut[n - 1];
        }
    }

    class Solution {
        public int minCut(String s) {
            int n = s.length();
            s = "#"+s;
            int[] dp = new int[n + 1];
            Arrays.fill(dp, Integer.MAX_VALUE / 2);
            // boolean[][] palin = new boolean[n + 1][n + 1];
            // for(int i = 1; i < n; i++){
            //     palin[i][i] = true;
            // }
            //最差就是n-1刀
            dp[0] = 0;
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= i; j++){
                    if(dp[j - 1] != Integer.MAX_VALUE / 2){
                        if(isPalin(s.substring(j, i+1))){
                            dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                        }
                    }
                }
            }
            return dp[n] - 1;
        }

        private boolean isPalin(String s){
            int l = 0;
            int r = s.length() - 1;
            while(l < r){
                if(s.charAt(l) == s.charAt(r)){
                    l++;
                    r--;
                }else{
                    return false;
                }
            }
            return true;
        }
    }



/*
dp[i] = minimum cuts to make 0~i palindrome

x x x x x i
首先本身切一刀就是palindrome
dp[i] = dp[i-1]+1
然后我们可以往前走，只要找到了一个palin并且这个前面也是palin的cut
*/
}
