package BloombergOnsite;

import java.util.ArrayList;
import java.util.List;

public class lt797allPathsSourceTarget {

    class Solution {
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            List<List<Integer>> res = new ArrayList<>();
            int n = graph.length;
            List<Integer> list = new ArrayList<>();
            list.add(0);
            dfs(graph, 0, n - 1, list, res);
            return res;
        }

        private void dfs(int[][] graph, int cur, int end, List<Integer> list, List<List<Integer>> res){
            if(cur == end){
                res.add(new ArrayList<>(list));
                return;
            }
            //loop neighbor
            for(int i = 0; i < graph[cur].length; i++){
                list.add(graph[cur][i]);
                dfs(graph, graph[cur][i], end, list, res);
                list.remove(list.size() - 1);
            }
        }
    }
}
