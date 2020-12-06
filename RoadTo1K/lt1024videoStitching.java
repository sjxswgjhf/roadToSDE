package RoadTo1K;

import java.util.Arrays;

public class lt1024videoStitching {


    class SolutionGreedy {

        /*
        [0,7] => [0, 1] + [1, 3] + [3, 7]

        [[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]]  T = 10
        [0,9]

        [0,2], [1,7], [1,5], [2,9], [4,6] , [8, 10]

        贪心，我们每次都把end能包含的所有next clips全靠考虑进来然后找到最大的那个coverage

        */
        public int videoStitching(int[][] clips, int T) {
            Arrays.sort(clips, (a,b)->a[0]==b[0] ? b[1] - a[1] : a[0] - b[0]);
            int left = clips[0][0];
            if(left != 0){
                return -1;
            }
            int right = clips[0][1];
            int res = 1;
            int idx = 1;
            if(right >= T){
                return res;
            }
            while(idx < clips.length){
                int candidateIdx = idx;
                //可能下个candidate已经接不上当前的right了, [0，2]【[4,8】
                if(clips[candidateIdx][0] > right){
                    return -1;
                }
                res++;
                while(idx < clips.length && clips[idx][0] <= right){
                    if(clips[candidateIdx][1] < clips[idx][1]){
                        candidateIdx = idx;
                    }
                    idx++;
                }
                right = clips[candidateIdx][1];
                if(right >= T){
                    return res;
                }

            }
            return -1;
        }
    }

    class SolutionFast {
        public int videoStitching(int[][] clips, int T) {
            int[] dp = new int[T + 1];
            Arrays.fill(dp, T + 1);
            dp[0] = 0;
            for(int i = 1; i <= T; i++){
                for(int[] c : clips){
                    if(c[0] <= i && i <= c[1]){
                        dp[i] = Math.min(dp[i], dp[c[0]] + 1);
                    }
                }
            }
            return dp[T] == T + 1 ? -1 : dp[T];
        }
    }

    class Solution {
        public int videoStitching(int[][] clips, int T) {

            int[][] dp = new int[T + 1][T + 1];
            for(int i = 0; i <= T; i++){
                Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
            }
            dp[0][0] = 0;
            int n = clips.length;
            // Arrays.sort(clips, (a,b)-> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
            for(int i = 0; i <= T; i++){
                for(int j = i + 1; j <= T; j++){
                    for(int k = 0; k < n; k++){
                        int start = clips[k][0];
                        int end = clips[k][1];
                        if(end < i || start > j){
                            continue;
                        }
                        //当前在范围内，三种情况，一种是clip完全覆盖i~j
                        if(start <= i && end >= j){
                            dp[i][j] = 1;
                        }
                        //覆盖前一部分
                        else if(start < i && end < j){
                            dp[i][j] = Math.min(dp[i][j], dp[start][i] + 1);
                        }
                        //覆盖后一部分
                        else if(start > i && end >= j){
                            dp[i][j] = Math.min(dp[i][j], dp[i][start] + 1);
                        }
                        //ij覆盖clip
                        else{
                            continue;
                        }
                    }
                }
            }
            return dp[0][T] >= Integer.MAX_VALUE / 2 ? -1 : dp[0][T];
        }
    }

/*
[0,7] => [0, 1] + [1, 3] + [3, 7]

[[0,2],[4,6],[8,10],[1,9],[1,5],[5,9]]  T = 10
[0,9]

[0,2], [1,7], [1,5], [2,9], [4,6] , [8, 10]

1 + 1 + 1 = 3

dp[0][T]:

dp[i][j]: the minimum nums of clips cover from i ~ j

dp[i][j]:
    dp[i][j] = dp[i][m] + clip(m, j);
*/


}
