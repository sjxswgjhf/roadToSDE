package RoadTo1K;

import java.util.HashMap;

public class lt930numSubarraysWithSum {

    class Solution {
        /*
        0 0 1 0 1 0 1 0   s = 2
        0 0 1 1 2 2 3 3

        x x [i x x j] x x x
        sum[i : j] = prefix[j] - prefix[i - 1] = S
        prefix[i - 1] = prefix[j] - S

        map:
        0 3
        1 2
        2 2
        3 2

        3 + 3 + 2 + 2

        map: prefix -> count of idx

        */
        public int numSubarraysWithSum(int[] A, int S) {
            int n = A.length;
            int[] prefix = new int[n + 1];
            for(int i = 1; i <= n; i++){
                prefix[i] = prefix[i - 1] + A[i - 1];
            }
            HashMap<Integer, Integer> map = new HashMap<>();
            int count = 0;
        /*
        要先填充一个padding 前缀为0是1
        如果正好是 1 0 0 1 0 s = 2
        1 0 0 1是前缀和是2，然后我们去map找prefix - 2的时候，会发现是0不是1，所以要先添加一个padding
        */
            map.put(0, 1);
            for(int i = 1; i <= n; i++){
                count += map.getOrDefault(prefix[i] - S, 0);
                // System.out.println(prefix[i] - S + " " + map.getOrDefault(prefix[i] - S, 0));
                map.put(prefix[i], map.getOrDefault(prefix[i], 0) + 1);
            }
            return count;
        }
    }


}
