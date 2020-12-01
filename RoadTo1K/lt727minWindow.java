package RoadTo1K;

public class lt727minWindow {
    class Solution {
        /*
        S = abcdebdde
        T = bde
        A: bcde, bdde

        这里不用担心sequence的问题，只要s的substring前i个包含了t的前j个，那么后面的i跟j一样的话就是符合的subsequence，

        dp[i][j]: find the minimum (contiguous) substring W of S[0 ~ i] and ending with S[i], so that T[0 ~ j]
        那么当i跟j相等的时候，如果前面的i-1包含了j-1的话，就说明~i是包含~j的subsequence，
        如果不想等，那么只有~i-1包含了~j的话，~i才是个有效的subsequence，

        xxxx[xxxx] i
        yyyy j

        i == j: 如果前面有一段min包含了t的0~j-1，那么我们只要加上1，就是最短的len去包含t的0~j
                dp[i-1][j-1] + 1
        i != j: 如果当前i跟j不一样，那么如果我们前面有一段包含了t的0~j，那么我们的s的idx~i也可以包含0~j。
                dp[i-1][j] + 1
        a
        b
        1 1 1073741824
        a
        bd
        1 2 1073741824
        a
        bde
        1 3 1073741824

        ab
        b
        2 1 1
        ab
        bd
        2 2 1073741825
        ab
        bde
        2 3 1073741825

        abc
        b
        3 1 2
        abc
        bd
        3 2 1073741826
        abc
        bde
        3 3 1073741826

        abcd
        b
        4 1 3
        abcd
        bd
        4 2 3
        abcd
        bde
        4 3 1073741827

        abcde
        b
        5 1 4
        abcde
        bd
        5 2 4
        abcde
        bde
        5 3 4

        abcdeb
        b
        6 1 1
        abcdeb
        bd
        6 2 5
        abcdeb
        bde
        6 3 5

        abcdebd
        b
        7 1 2
        abcdebd
        bd
        7 2 2
        abcdebd
        bde
        7 3 6

        abcdebdd
        b
        8 1 3
        abcdebdd
        bd
        8 2 3
        abcdebdd
        bde
        8 3 7

        abcdebdde
        b
        9 1 4
        abcdebdde
        bd
        9 2 4
        abcdebdde
        bde
        9 3 4

        */
        public String minWindow(String s, String t) {

            int m = s.length();
            int n = t.length();
            s = "#"+s;
            t = "#"+t;
            int[][] dp = new int[m+1][n+1];
            //0 j 无解
            for(int j = 1; j <= n; j++){
                dp[0][j] = Integer.MAX_VALUE / 2;
            }
            //i 0 如果t是空字符，dp[i][0]=0就可以
            for(int i = 1; i <= m; i++){
                dp[i][0] = 0;
            }
            dp[0][0] = 0;
            for(int i = 1; i <= m; i++){
                for(int j = 1; j <= n; j++){
                    if(s.charAt(i) == t.charAt(j)){
                        dp[i][j] = dp[i-1][j-1] + 1;
                    }
                    else{
                        dp[i][j] = dp[i-1][j] + 1;
                    }
                }
            }
            int res = Integer.MAX_VALUE / 2;
            int pos = -1;
            for(int i = 1; i <= m; i++){
                //一定要以n结尾的s里面的substring
                if(dp[i][n] < res){
                    res = dp[i][n];
                    pos = i;
                }
            }

            //pos是padding过了
            return pos == -1 ? "" : s.substring(pos - res + 1, pos + 1);
        }
    }


}
