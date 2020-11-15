package dailyProblem;

import java.util.Arrays;

public class lt1494minNUmberOfSemesters {

    class Solution {
        /*
        能根据dependencies构建degree的图像

        课的状态:
         1.当前课可以take，我take它
         2.当前课可以take，因为次数的限制我不take它，take别的
         3.当前课还不能take
        */
        public int minNumberOfSemesters(int n, int[][] dependencies, int k) {
            int[] preCourse = new int[n];
            //建立每节课要求的degrees，不存在的就是没要求的
            for(int[] dep : dependencies){
                preCourse[dep[1] - 1] += 1 << (dep[0] - 1);
            }
            int[] prereq = new int[1 << n];
            for(int state = 0; state < (1 << n); state++){
                prereq[state] = 0;
                for(int i = 0; i < n; i++){
                    if(((state >> i) & 1) == 1){
                        prereq[state] |= preCourse[i];
                    }
                }
            }

            //0000 代表当前的课上了多少，1111为最终状态
            int[] dp = new int[1 << n];
            Arrays.fill(dp, Integer.MAX_VALUE / 2);
            dp[0] = 0;
        /*
        我有m个课，能选k个，怎么做dp
        */
            for(int state = 0; state < (1 << n); state++){
                for(int subset = state; subset >= 0; subset = (subset - 1) & state){
                    if((Integer.bitCount(state) - Integer.bitCount(subset) <= k) && (subset & prereq[state]) == prereq[state]){
                        dp[state] = Math.min(dp[state], dp[subset] + 1);
                    }
                    if(subset == 0){
                        break;
                    }
                }
            }
            return dp[(1<<n) - 1];
        }
    }
}
