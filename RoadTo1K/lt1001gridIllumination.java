package RoadTo1K;

import java.util.HashMap;

public class lt1001gridIllumination {

        /*
    1 <= N <= 10^9
    0 <= lamps.length <= 20000
    对于每个被点亮的cell，放入hashmap，并且记录被几个点亮，这样，queries的时候，每遇到一个，把周边8个检查下，有亮的就减去一个
    然后再有一个map去记录哪些是亮的
    这题一大难点就是怎么把row管row，col管col，diagonal管diagonal，counter diagonal管counter diagonal
    row跟col直接用x,y的值就可以，diagonal那边要特殊处理，
    这样所有的diagonal被归纳到一起
    x-y
    0 -1 -2 -3
    1  0 -1 -2
    2  1  0 -1
    同里counter diagonal
    x+y
    0 1 2 3
    1 2 3 4
    2 3 4 5
    3 4 5 6
    */

    class Solution {
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}, {1,1}, {1,-1}, {-1,1}, {-1,-1}, {0,0}};

        public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
            HashMap<Integer, Integer> m1 = new HashMap();       // row number to count of lamps
            HashMap<Integer, Integer> m2 = new HashMap();       // col number to count of lamps
            HashMap<Integer, Integer> m3 = new HashMap();       // diagonal x-y to count of lamps
            HashMap<Integer, Integer> m4 = new HashMap();       // diagonal x+y to count of lamps
            HashMap<Integer, Boolean> m5 = new HashMap();       // whether lamp is  ON|OFF

            // increment counters while adding lamps
            for(int i=0; i<lamps.length; i++){
                int x = lamps[i][0];
                int y = lamps[i][1];
                m1.put(x, m1.getOrDefault(x, 0) + 1);
                m2.put(y, m2.getOrDefault(y, 0) + 1);
                m3.put(x-y, m3.getOrDefault(x-y, 0) + 1);
                m4.put(x+y, m4.getOrDefault(x+y, 0) + 1);
                m5.put(N*x + y, true);
            }

            int[] ans = new int[queries.length];
            // address queries
            for(int i=0; i<queries.length; i++){
                int x = queries[i][0];
                int y = queries[i][1];

                ans[i] = (m1.getOrDefault(x, 0) > 0 || m2.getOrDefault(y, 0) > 0 ||
                        m3.getOrDefault(x-y, 0) > 0 || m4.getOrDefault(x+y, 0) > 0) ? 1 : 0;
                // switch off the lamps, if any
                for(int d=0; d<dirs.length; d++){
                    int x1 = x + dirs[d][0];
                    int y1 = y + dirs[d][1];
                    if(m5.containsKey(N*x1 + y1) && m5.get(N*x1 + y1)){
                        // the lamp is on, turn it off, so decrement the count of the lamps
                        m1.put(x1, m1.getOrDefault(x1, 1) - 1);
                        m2.put(y1, m2.getOrDefault(y1, 1) - 1);
                        m3.put(x1 - y1, m3.getOrDefault(x1 - y1, 1) - 1);
                        m4.put(x1 + y1, m4.getOrDefault(x1 + y1, 1) - 1);
                        m5.put(N*x1+y1, false);
                    }
                }
            }

            return ans;
        }
    }
}
