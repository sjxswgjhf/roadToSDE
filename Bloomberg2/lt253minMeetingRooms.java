package Bloomberg2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lt253minMeetingRooms {

    class Solution {
        public int minMeetingRooms(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
            List<int[]> rooms = new ArrayList<>();
            for(int[] interval : intervals){
                if(rooms.size() == 0){
                    rooms.add(interval);
                }else{
                    boolean findRoom = false;
                    for(int i = 0; i < rooms.size(); i++){
                        int[] room = rooms.get(i);
                        //room is avaiable
                        if(room[1] <= interval[0]){
                            findRoom = true;
                            rooms.set(i, interval);
                            break;
                        }
                    }
                    if(!findRoom){
                        rooms.add(interval);
                    }
                }
            }
            return rooms.size();
        }
    }
}
