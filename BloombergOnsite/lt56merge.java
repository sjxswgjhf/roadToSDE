package BloombergOnsite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lt56merge {
    class Solution {
        /*

        [[1,3],[2,6],[8,10],[15,18]]

        [1, 6]
        [8, 10]
        [15, 18]


        */
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, (a, b)->a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
            List<int[]> list = new ArrayList<>();
            for(int[] interval : intervals){
                int start = interval[0];
                int end = interval[1];
                boolean merge = false;
                for(int i = 0; i < list.size(); i++){
                    int tmpS = list.get(i)[0];
                    int tmpE = list.get(i)[1];
                    if(tmpE >= start){
                        int[] newInterval = {tmpS, Math.max(tmpE, end)};
                        list.set(i, newInterval);
                        merge = true;
                        break;
                    }
                }
                if(!merge){
                    list.add(interval);
                }
            }
            int[][] res = new int[list.size()][2];
            for(int i = 0 ; i < list.size(); i++){
                res[i][0] = list.get(i)[0];
                res[i][1] = list.get(i)[1];
            }
            return res;
        }
    }
}
