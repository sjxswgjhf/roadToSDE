package weeklyContest;

public class lt1646wk214 {

    class Solution {
        /*
        0 = 0
        1 = 1
        2 = 1
        3 = 2
        4 = 1
        5 = 3
        6 = 2
        7 = 3
        8 = 1
        9 = 4
        10 = 3
        11 = 5

        好像没啥规律
        */
        public int getMaximumGenerated(int n) {
            if(n == 0){
                return 0;
            }
            if(n == 1){
                return 1;
            }
            int[] res = new int[n + 1];
            res[0] = 0;
            res[1] = 1;
            int max = 1;
            for(int i = 2; i <= n; i++){
                if(i % 2 == 0){
                    res[i] = res[i / 2];
                }
                else{
                    res[i] = res[i / 2] + res[i / 2 + 1];
                }
                max = Math.max(res[i], max);
            }
            return max;
        }
    }
}
