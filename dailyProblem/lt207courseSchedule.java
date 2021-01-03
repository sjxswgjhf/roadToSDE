package dailyProblem;

import java.util.*;

public class lt207courseSchedule {

    class Solution {
        /*
        topological sort
        */
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            int[] degrees = new int[numCourses];
            for(int[] pre : prerequisites){
                int course = pre[0];
                int req = pre[1];
                List<Integer> children = map.getOrDefault(req, new ArrayList<>());
                children.add(course);
                map.put(req, children);
                degrees[course]++;
            }
            int takeCourses = 0;
            Queue<Integer> queue = new LinkedList<>();
            for(int i = 0; i < numCourses; i++){
                if(degrees[i] == 0){
                    queue.add(i);
                    takeCourses++;
                }
            }
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    int course = queue.poll();
                    List<Integer> children = map.getOrDefault(course, new ArrayList<>());
                    for(int child : children){
                        degrees[child]--;
                        if(degrees[child] == 0){
                            queue.add(child);
                            takeCourses++;
                        }
                    }
                }
            }
            return takeCourses == numCourses;
        }
    }
}
