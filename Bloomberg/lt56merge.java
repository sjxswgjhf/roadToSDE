package Bloomberg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lt56merge {

    class Solution {
        public int[][] merge(int[][] intervals) {
            if(intervals == null || intervals.length == 0){
                return new int[0][0];
            }
            Arrays.sort(intervals, (a, b)-> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
            List<int[]> list = new ArrayList<>();
            for(int[] interval : intervals){
                if(list.size() == 0){
                    list.add(interval);
                }else{
                    boolean merged = false;
                    for(int i = 0; i < list.size(); i++){
                        int[] tmp = list.get(i);
                        if(tmp[1] < interval[0]){
                            continue;
                        }
                        else{
                            tmp[1] = Math.max(tmp[1], interval[1]);
                            list.set(i, tmp);
                            merged = true;
                            break;
                        }
                    }
                    if(!merged){
                        list.add(interval);
                    }
                }
            }
            int[][] res = new int[list.size()][2];
            for(int i = 0 ; i < list.size(); i++){
                int[] cur = list.get(i);
                res[i][0] = cur[0];
                res[i][1] = cur[1];
            }
            return res;
        }
    }
}
