package graphProblemTrainning;
import java.util.*;

public class lt743networkDelayTime {
    /*
    典型Dijkstra's Algorithm
    先用map建立有向图的edge，然后建个array为所有idx的当前的dist，初始为infinite，出发点为0
    然后从idx k出发，依次更新neighbor idx的dist如果neighbor idx当前weight > cur.idx.weight + dist，放入queue，
    这题不需要用到visited数组去记录访问过没有，这是道有向的图，如果是无向图就需要visited数组，去避免重复计算

     类似题的升级版是lt1631
     */

    class Solution {

        public int networkDelayTime(int[][] times, int N, int K) {

            HashMap<Integer, List<int[]>> map = new HashMap<>();
            for(int[] time : times){
                map.putIfAbsent(time[0], new ArrayList<>());
                List<int[]> list = map.get(time[0]);
                list.add(new int[]{time[1], time[2]});
                map.put(time[0], list);
            }
            int[] weights = new int[N + 1];
            Arrays.fill(weights, Integer.MAX_VALUE);
            weights[K] = 0;
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{K, 0});
            // boolean[] visited = new boolean[];
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    int[] cur = queue.poll();
                    int node = cur[0];
                    List<int[]> list = map.getOrDefault(node, new ArrayList<>());
                    for(int[] neigh : list){
                        int nextNode = neigh[0];
                        int dis = neigh[1];
                        if(weights[nextNode] > weights[node] + dis){
                            weights[nextNode] = weights[node] + dis;
                            queue.add(new int[]{nextNode, weights[node] + dis});
                        }
                    }
                }
            }
            int res = 0;
            for(int i = 1; i <= N; i++){
                res = Math.max(res, weights[i]);
            }
            return res == Integer.MAX_VALUE ? -1 : res;
        }
    }
}
