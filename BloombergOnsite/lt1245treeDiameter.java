package BloombergOnsite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class lt1245treeDiameter {

    class Solution {
    /*
    每个node都可以是root,所以我们直接把0当root，
    然后dfs，每个root的children都去dfs，找最远到达的距离，但是我们需要diameter，所以需要两个最远的距离，
    我们需要记录两个值，我们也要把children的diamater考虑进去，不一定是root的最远，所以我们把res跟两个最深的距离最比较，
    然后我们返回给上一层node的时候，我们取一个最远的返回，我们还要个visited来记录已经访问过的node，避免重复访问
    */

        HashMap<Integer, List<Integer>> graph;
        int res = 0;
        public int treeDiameter(int[][] edges) {
            graph = new HashMap<>();
            for(int[] edge : edges){
                int e1 = edge[0];
                int e2 = edge[1];
                List<Integer> l1 = graph.getOrDefault(e1, new ArrayList<>());
                l1.add(e2);
                graph.put(e1, l1);
                List<Integer> l2 = graph.getOrDefault(e2, new ArrayList<>());
                l1.add(e1);
                graph.put(e2, l2);
            }
            int n = edges.length;
            boolean[] visited = new boolean[n + 1];
            dfs(0, visited);
            return res;
        }

        private int dfs(int cur, boolean[] visited){
            int max = 0, secondMax = 0;
            visited[cur] = true;
            for(Integer neighbor : graph.getOrDefault(cur, new ArrayList<>())){
                int distance = 0;
                if(!visited[neighbor]){
                    distance = dfs(neighbor, visited) + 1;
                    if(distance > max){
                        secondMax = max;
                        max = distance;
                    }
                    else if(distance > secondMax){
                        secondMax = distance;
                    }
                }
            }
            res = Math.max(res, max + secondMax);
            return max;
        }
    }
}
