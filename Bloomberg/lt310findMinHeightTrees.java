package Bloomberg;

import java.util.*;

public class lt310findMinHeightTrees {

    class SolutionTP {
        /*
        对于一个无向连通的graph来说，什么样的node是到所有node的路径最短的。那肯定是degrees最大的那些。那么我们怎么样在这些degrees较大的里面找到正确的解呢。
        我们用拓扑排序的方法，我们知道拓扑排序一开始从degree最小的开始，然后到最大的。那么在这题里面也就是从最外围的leaf节点开始去除，直到最后留下的node就是最后的答案
        */
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            List<Integer> res = new ArrayList<>();
            if(edges == null || edges.length == 0){
                res.add(0);
                return res;
            }
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            int[] degrees = new int[n];
            for(int[] edge : edges){
                int from = edge[0];
                int to = edge[1];
                List<Integer> l1 = map.getOrDefault(from, new ArrayList<>());
                List<Integer> l2 = map.getOrDefault(to, new ArrayList<>());
                l1.add(to);
                l2.add(from);
                map.put(from, l1);
                map.put(to, l2);
                degrees[from]++;
                degrees[to]++;
            }

            Queue<Integer> queue = new LinkedList<>();
            for(int i = 0; i < n; i++){
                if(degrees[i] == 1){
                    queue.add(i);
                }
            }
            while(!queue.isEmpty()){
                res.clear();
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    int cur = queue.poll();
                    res.add(cur);
                    degrees[cur]--;
                    List<Integer> neighs = map.get(cur);
                    for(int neigh : neighs){
                        degrees[neigh]--;
                        if(degrees[neigh] == 1){
                            queue.add(neigh);
                        }
                    }
                }
            }
            return res;
        }
    }

    class SolutionTLE {
        /*
        1. build bi-dir graph
        2. for each i do dfs check the depth
        n^2 TLE
        */
        int maxDep = Integer.MAX_VALUE;
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            for(int i = 0; i < n; i++){
                map.put(i, new ArrayList<>());
            }
            for(int[] edge : edges){
                int from = edge[0];
                int to = edge[1];
                List<Integer> l1 = map.get(from);
                List<Integer> l2 = map.get(to);
                l1.add(to);
                l2.add(from);
                map.put(from, l1);
                map.put(to, l2);
            }
            List<Integer> res = new ArrayList<>();
            for(int i = 0; i < n; i++){
                int depth = findDepth(i, map, n);
                if(depth <= maxDep){
                    if(depth < maxDep){
                        res.clear();
                        res.add(i);
                    }else{
                        res.add(i);
                    }
                    maxDep = depth;
                }
            }
            return res;
        }

        private int findDepth(int cur, HashMap<Integer, List<Integer>> map, int n){
            Queue<Integer> queue = new LinkedList<>();
            queue.add(cur);
            int depth = 0;
            boolean[] visited = new boolean[n];
            while(!queue.isEmpty()){
                int size = queue.size();
                depth++;
                for(int i = 0; i < size; i++){
                    int next = queue.poll();
                    visited[next] = true;
                    for(int neigh : map.get(next)){
                        if(!visited[neigh]){
                            queue.add(neigh);
                        }
                    }
                }
            }
            return depth;
        }
    }
}
