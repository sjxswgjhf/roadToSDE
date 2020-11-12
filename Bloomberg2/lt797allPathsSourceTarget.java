package Bloomberg2;

import java.util.ArrayList;
import java.util.List;

public class lt797allPathsSourceTarget {

    /*
    DAG directed graph, 没必要去避免重复
     */
    class Solution {
        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            List<List<Integer>> res = new ArrayList<>();
            int n = graph.length;
            List<Integer> list = new ArrayList<>();
            list.add(0);
            helper(graph, res, list, 0, n-1);
            return res;
        }

        private void helper(int[][] graph, List<List<Integer>> res, List<Integer> list, int cur, int target){
            if(cur == target){
                res.add(new ArrayList<>(list));
                return;
            }
            //loop neighbor
            for(int neigh : graph[cur]){
                list.add(neigh);
                helper(graph, res, list, neigh, target);
                list.remove(list.size() - 1);
            }
        }
    }
}
