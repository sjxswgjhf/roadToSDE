package dailyProblem;

import java.util.*;

public class lt210courseScheduleII {

    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            int[] res = new int[numCourses];
            int[] degrees = new int[numCourses];
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            for(int[] pre : prerequisites){
                List<Integer> list = map.getOrDefault(pre[1], new ArrayList<>());
                list.add(pre[0]);
                map.put(pre[1], list);
                degrees[pre[0]]++;
            }
            Queue<Integer> queue = new LinkedList<>();
            for(int i = 0; i < numCourses; i++){
                if(degrees[i] == 0){
                    queue.add(i);
                }
            }

            int count = 0;
            int idx = 0;
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    int cur = queue.poll();
                    count++;
                    res[idx++] = cur;
                    for(int child : map.getOrDefault(cur, new ArrayList<>())){
                        degrees[child]--;
                        if(degrees[child] == 0){
                            queue.add(child);
                        }
                    }
                }
            }
        /*
        注意edge case
        */
            if(count != numCourses){
                return new int[0];
            }
            return res;
        }
    }
}
