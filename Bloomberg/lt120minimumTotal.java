package Bloomberg;

import java.util.List;

public class lt120minimumTotal {

    class Solution {
        /*

    [2],
    [3,4],
    [6,5,7],
    [4,1,8,3]

    下一行只跟对应的左上跟正上方有关
        */
        public int minimumTotal(List<List<Integer>> triangle) {
            if(triangle == null || triangle.size() == 0){
                return 0;
            }
            int m = triangle.size();
            int n = triangle.get(m - 1).size();
            int[] dp = new int[n];
            for(int i = 0; i < m; i++){
                int[] cur = new int[n];
                List<Integer> list = triangle.get(i);
                for(int j = 0; j < list.size(); j++){
                    if(j == 0){
                        cur[j] = dp[j] + list.get(j);
                    }
                    else if(j == list.size() - 1){
                        cur[j] = dp[j-1] + list.get(j);
                    }else{
                        cur[j] = Math.min(dp[j-1], dp[j]) + list.get(j);
                    }
                }
                dp = cur;
            }

            int max = Integer.MAX_VALUE;
            for(int num : dp){
                max = Math.min(num, max);
            }
            return max;
        }
    }
}
