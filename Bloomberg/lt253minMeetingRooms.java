package Bloomberg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lt253minMeetingRooms {

    class Solution {
        public int minMeetingRooms(int[][] intervals) {
            List<int[]> rooms = new ArrayList<>();
            //排序要记得把end也要考虑，不然编译通过了，跑出来不通过
            Arrays.sort(intervals, (a,b)->a[0] == b[0]? a[1]-b[1] : a[0]-b[0]);
            for(int[] interval : intervals){
                if(rooms.size() == 0){
                    rooms.add(interval);
                }
                else{
                    boolean find = false;
                    for(int i = 0; i < rooms.size(); i++){
                        int[] room = rooms.get(i);
                        if(room[1] <= interval[0]){
                            room[0] = interval[0];
                            room[1] = interval[1];
                            find = true;
                            break;
                        }
                    }
                    if(!find){
                        rooms.add(interval);
                    }
                }
            }
            return rooms.size();
        }
    }

// [300, 5870]
// [518, 2918] [4284,5907],
// [848, 3846] [4466,4781],
// [1293, 2986]

}
