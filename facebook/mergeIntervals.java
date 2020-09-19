package facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mergeIntervals {

    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals);
            List<int[]> list = new ArrayList<>();
            int slow = 0, fast = 0;
            while(fast < intervals.length){
                int begin = intervals[slow][0];
                int end = intervals[slow][1];
                //[[1,4],[0,2],[3,5]]   注意这种case
                // [[1,3],[2,6],[8,10],[15,18]]
                while(fast < intervals.length && end >= intervals[fast][0]){
                    end = Math.max(end, intervals[fast][1]);
                    fast++;
                }
                list.add(new int[]{begin, end});
                slow = fast;
            }
            int[][] res = new int[list.size()][2];
            for(int i = 0; i < list.size(); i++){
                res[i] = list.get(i);
            }
            return res;
        }
    }
}
