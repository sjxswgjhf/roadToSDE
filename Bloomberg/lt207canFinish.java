package Bloomberg;

import java.util.*;

public class lt207canFinish {

    class Solution {
        /*
        topological sort
        */
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            int[] degrees = new int[numCourses];
            Arrays.fill(degrees, 1);
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            for(int[] prerequest : prerequisites){
                int request = prerequest[1];
                int course = prerequest[0];
                List<Integer> children = map.getOrDefault(request, new ArrayList<>());
                children.add(course);
                degrees[course]++;
                map.put(request, children);
            }
            int count = 0;
            Queue<Integer> queue = new LinkedList<>();
            for(int i = 0 ; i < numCourses; i++){
                if(degrees[i] == 1){
                    queue.add(i);
                    count++;
                }
            }
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    int course = queue.poll();
                    List<Integer> children = map.getOrDefault(course, new ArrayList<>());
                    for(int child : children){
                        degrees[child]--;
                        if(degrees[child] == 1){
                            queue.add(child);
                            count++;
                        }
                    }
                }
            }
            return count == numCourses;
        }
    }
}
