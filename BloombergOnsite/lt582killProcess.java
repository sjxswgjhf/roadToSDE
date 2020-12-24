package BloombergOnsite;

import java.util.*;

public class lt582killProcess {
    class Solution {
        public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
            List<Integer> res = new ArrayList<>();
            HashMap<Integer, Queue<Integer>> map = new HashMap<>();
            for(int i = 0; i < pid.size(); i++){
                int p = pid.get(i);
                int pp = ppid.get(i);
                Queue<Integer> queue = map.getOrDefault(pp, new LinkedList<>());
                queue.add(p);
                map.put(pp, queue);
            }
            res.add(kill);
            dfs(kill, map, res);
            return res;
        }

        private void dfs(int kill, HashMap<Integer, Queue<Integer>> map, List<Integer> res){
            Queue<Integer> queue = map.getOrDefault(kill, new LinkedList<>());
            while(!queue.isEmpty()){
                int child = queue.poll();
                res.add(child);
                dfs(child, map, res);
            }
        }
    }
}
