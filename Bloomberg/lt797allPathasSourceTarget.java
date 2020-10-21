package Bloomberg;

import java.util.ArrayList;
import java.util.List;

public class lt797allPathasSourceTarget {

    /*
    这题特殊点是DAG的graph，我们不需要考虑去重了。直接把backtracking，注意先把start加入path
     */

    class Solution {
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

            List<List<Integer>> res = new ArrayList<>();
            int n = graph.length;
            List<Integer> path = new ArrayList<>();
            path.add(0);
            dfs(graph, 0, n - 1, res, path);
            return res;
        }

        private void dfs(int[][] graph, int cur, int end, List<List<Integer>> res, List<Integer> list){
            if(cur == end){
                res.add(new ArrayList<>(list));
                return;
            }
            for(int neigh : graph[cur]){
                list.add(neigh);
                dfs(graph, neigh, end, res, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
