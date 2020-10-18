package Bloomberg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class minMeetingRooms {

    class Solution {
        /*
        [[0, 30],[5, 10],[15, 20]]
        [0, 30]
        [5, 10]=>[15,20]
        [[6,15],[6,17], [13,20]]
        */
        public int minMeetingRooms(int[][] intervals) {
            Arrays.sort(intervals, (a,b)-> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
            int res = 0;
            int n = intervals.length;
            List<Integer> endingTime = new ArrayList<>();
            //endintTime: 30, 20
            for(int[] interval : intervals){
                int start = interval[0];
                int end = interval[1];
                if(endingTime.size() == 0){
                    endingTime.add(end);
                    res++;
                }else{
                    boolean find = false;
                    for(int i = 0; i < endingTime.size(); i++){
                        if(endingTime.get(i) <= start){
                            endingTime.set(i, end);
                            find = true;
                            break;
                        }
                    }
                    if(!find){
                        res++;
                        endingTime.add(end);
                    }
                }
            }
            return res;
        }
    }
}
