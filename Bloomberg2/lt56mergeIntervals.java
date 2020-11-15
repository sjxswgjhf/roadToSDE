package Bloomberg2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lt56mergeIntervals {

    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
            List<int[]> list = new ArrayList<>();
            for(int[] interval : intervals){
                if(list.size() == 0){
                    list.add(interval);
                }else{
                    boolean find = false;
                    for(int i = 0; i < list.size(); i++){
                        int[] cur = list.get(i);
                        //overlapping happen
                        if(cur[1] >= interval[0]){
                            cur[1] = Math.max(interval[1], cur[1]);
                            list.set(i, cur);
                            find = true;
                            break;
                        }
                    }
                    if(!find){
                        list.add(interval);
                    }
                }
            }
            int[][] res = new int[list.size()][2];
            for(int i = 0; i < list.size(); i++){
                res[i][0] = list.get(i)[0];
                res[i][1] = list.get(i)[1];
            }
            return res;
        }
    }
}
