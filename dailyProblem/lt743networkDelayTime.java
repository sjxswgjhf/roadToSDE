package dailyProblem;

import java.util.*;

public class lt743networkDelayTime {

    class Solution {
        public int networkDelayTime(int[][] times, int N, int K) {
            HashMap<Integer, List<int[]>> map = new HashMap<>();
            for(int i = 0; i <= N; i++){
                map.put(i, new ArrayList<>());
            }
            for(int[] time : times){
                int from = time[0];
                int to = time[1];
                int cost = time[2];
                List<int[]> list = map.get(from);
                list.add(new int[]{to, cost});
            }
            Queue<Integer> queue = new LinkedList<>();
            int res = 0;
            queue.add(K);
            int[] weights = new int[N + 1];
            Arrays.fill(weights, Integer.MAX_VALUE);
            weights[K] = 0;
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    int cur = queue.poll();
                    List<int[]> children = map.get(cur);
                    for(int[] child : children){
                        if(weights[child[0]] > weights[cur] + child[1]){
                            weights[child[0]] = weights[cur] + child[1];
                            queue.add(child[0]);
                        }
                    }
                }
            }
            for(int i = 1; i <= N; i++){
                res = Math.max(weights[i], res);
            }
            return res == Integer.MAX_VALUE ? -1 : res;
        }
    }
}
