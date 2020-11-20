package RoadTo1K;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class lt582killProcess {
    class Solution {
        public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            for(int i = 0; i < pid.size(); i++){
                int p = pid.get(i); //child
                int pp = ppid.get(i); //parent
                if(pp == 0){
                    continue;
                }else{
                    List<Integer> children = map.getOrDefault(pp, new ArrayList<>());
                    children.add(p);
                    map.put(pp, children);
                }
            }
            HashSet<Integer> set = new HashSet<>();
            dfs(map, set, kill);
            return new ArrayList<>(set);
        }

        private void dfs(HashMap<Integer, List<Integer>> map, HashSet<Integer> set, int kill){
            set.add(kill);
            if(!map.containsKey(kill)){
                return;
            }
            for(int child : map.get(kill)){
                dfs(map, set, child);
            }
        }
    }
}
