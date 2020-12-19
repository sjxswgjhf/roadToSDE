package dailyProblem;

import java.util.HashMap;

public class lt930numSubarraysWithSum {

    class Solution {
        /*
        这题用prefix sum来做，然后去更新当前prefix的个数
        0 1 1 2 2 3
        count: 1 + 1 + 2
        0: 1
        1: 1
        1: 2
        2: 1
        2: 2
        3: 1
        */
        public int numSubarraysWithSum(int[] A, int S) {
            int n = A.length;
            int[] prefix = new int[n + 1];
            for(int i = 1; i <= n; i++){
                prefix[i] = A[i-1] + prefix[i - 1];
            }
            int count = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i <= n; i++){
                count += map.getOrDefault(prefix[i] - S, 0);

                map.put(prefix[i], map.getOrDefault(prefix[i], 0) + 1);
            }
            return count;
        }
    }
}
