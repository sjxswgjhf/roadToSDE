package weeklyContest;

public class lt1631wk213 {

    class Solution {
        /*
        1
        a e i o u
        2
        5 * 5 - 4 - 3- 2 -1 = 25 - 10 = 15
        3
        5 * 5 * 5 - 4 * 3 -

        */
        public int countVowelStrings(int n) {
            if(n == 1){
                return 5;
            }
            if(n == 2){
                return 15;
            }
            int[] dpa = new int[n + 1];
            int[] dpe = new int[n + 1];
            int[] dpi = new int[n + 1];
            int[] dpo = new int[n + 1];
            int[] dpu = new int[n + 1];
            int[] dp = new int[n + 1];
            dpa[1] = dpe[1] = dpi[1] = dpo[1] =dpu[1] =1;
            dpa[2] = 5; dpe[2] = 4; dpi[2] = 3; dpo[2] = 2; dpu[2] = 1;
            dp[1]=5;
            dp[2]=15;

            for(int i = 3; i <= n; i++){
                dpa[i] = dp[i-1];
                dpe[i] = dpa[i] - dpa[i - 1];
                dpi[i] = dpe[i] - dpe[i - 1];
                dpo[i] = dpi[i] - dpi[i - 1];
                dpu[i] = dpo[i] - dpo[i - 1];
                dp[i] = dpa[i]+ dpe[i]+dpi[i]+dpo[i]+dpu[i];
            }
            return dp[n];
        }
    }
}
