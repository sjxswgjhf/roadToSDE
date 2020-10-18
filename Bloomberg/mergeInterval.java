package Bloomberg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class mergeInterval {

    class Solution {
        public int[][] merge(int[][] intervals) {
            int n = intervals.length;
            List<int[]> res = new ArrayList<>();
            Arrays.sort(intervals, (a, b)->(a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]));
            for(int[] interval : intervals){
                boolean find = false;
                int start = interval[0];
                int end = interval[1];
                for(int i = 0; i < res.size(); i++){
                    if(res.get(i)[1] >= start){
                        int[] tmp = new int[]{res.get(i)[0], Math.max(res.get(i)[0], end)};
                        res.set(i, tmp);
                        find = true;
                        break;
                    }
                }
                if(!find){
                    int[] newInterval = new int[]{start, end};
                    res.add(newInterval);
                }
            }

            int[][] ans = new int[res.size()][2];
//            int idx = 0;
//            for(int[] r : res){
//                ans[idx][0] = r[0];
//                ans[idx][1] = r[1];
//                idx++;
//            }
            return res.toArray(ans);
        }
    }
}
