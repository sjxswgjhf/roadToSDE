package dailyProblem;

import java.util.*;

public class lt1462checkIfPrerequisite {

    class Solution {
        public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
            //adj
            HashMap<Integer, HashSet<Integer>> adjmap = new HashMap<>();
            HashMap<Integer, HashSet<Integer>> premap = new HashMap<>();
            int[] indegrees = new int[n];
            for(int i = 0; i < n ; i++){
                adjmap.put(i, new HashSet<>());
                premap.put(i, new HashSet<>());
            }
            for(int[] pre : prerequisites){
                HashSet<Integer> set = adjmap.get(pre[0]);
                set.add(pre[1]);
                indegrees[pre[1]]++;
                adjmap.put(pre[0], set);
            }
            Queue<Integer> queue = new LinkedList<>();
            for(int i = 0; i < n; i++){
                if(indegrees[i] == 0){
                    queue.add(i);
                }
            }
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0 ; i < size; i++){
                    int cur = queue.poll();
                    HashSet<Integer> childset = adjmap.get(cur);
                    for(int child : childset){
                        HashSet<Integer> set = premap.get(child);
                        set.add(cur);
                        //parent prequests is also pre
                        set.addAll(premap.get(cur));
                        indegrees[child]--;
                        if(indegrees[child] == 0){
                            queue.add(child);
                        }
                    }
                }
            }
            List<Boolean> res = new ArrayList<>();
            for(int[] query : queries){
                HashSet<Integer> pres = premap.get(query[1]);
                if(pres.contains(query[0])){
                    res.add(true);
                }else{
                    res.add(false);
                }
            }
            return res;
        }
    }

    /*
    太慢了，因为DFS的时候没有memory的帮助
     */
    class SolutionSlower {
        public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            for(int[] pre : prerequisites){
                List<Integer> children = map.getOrDefault(pre[0], new ArrayList<>());
                children.add(pre[1]);
                map.put(pre[0], children);
            }
            List<Boolean> res = new ArrayList<>();
            for(int[] query : queries){
                int parent = query[0];
                int child = query[1];
                HashSet<Integer> visited = new HashSet<>();
                res.add(find(parent, child, map, visited));
            }
            return res;
        }

        private boolean find(int p, int c, HashMap<Integer, List<Integer>> map, HashSet<Integer> visited){
            if(visited.contains(p)){
                return false;
            }
            if(p == c){
                return true;
            }
            visited.add(p);
            List<Integer> children = map.getOrDefault(p, new ArrayList<>());
            for(int child : children){
                if( find(child, c, map, visited)){
                    return true;
                }
            }
            return false;
        }
    }
}
