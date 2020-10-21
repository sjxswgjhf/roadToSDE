package Bloomberg;

import java.util.ArrayList;
import java.util.List;

public class lt797allPathsSourceTarget {

    class Solution {


        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

            List<List<Integer>> res = new ArrayList<>();
            int n = graph.length;
            dfs(graph, 0, n - 1, res, new ArrayList<>());

            return res;
        }

        private void dfs(int[][] graph, int cur, int end, List<List<Integer>> res, List<Integer> list){

            if(cur == end){
                res.add(new ArrayList<>(list));
                return;
            }
            for(int neigh : graph[cur]){
                list.add(cur);
                dfs(graph, neigh, end, res, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
