package dailyProblem;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class lt1306canReach {

    class Solution {
        public boolean canReach(int[] arr, int start) {
            int n = arr.length;
            HashSet<Integer> visited = new HashSet<>();
            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    int idx = queue.poll();
                    if(arr[idx] == 0){
                        return true;
                    }
                    visited.add(idx);
                    int back = idx - arr[idx] < 0 ? -1 : idx - arr[idx];
                    int forward = idx + arr[idx] > n - 1 ? -1 : idx + arr[idx];
                    if(back != -1 && !visited.contains(back)){
                        queue.add(back);
                    }
                    if(forward != -1 && !visited.contains(forward)){
                        queue.add(forward);
                    }
                }
            }
            return false;
        }
    }
}
