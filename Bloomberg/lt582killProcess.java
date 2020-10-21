package Bloomberg;

import java.util.*;

public class lt582killProcess {

    class Solution {
        /*
        directed graph problem: node with children list
        then dfs, avoid repeated calculate
        */
        public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
            List<Integer> res = new ArrayList<>();
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            for(int i = 0; i < pid.size(); i++){
                int id = pid.get(i);
                int parentid = ppid.get(i);
                if(parentid == 0){
                    continue;
                }else{
                    List<Integer> children = map.getOrDefault(parentid, new ArrayList<>());
                    children.add(id);
                    map.put(parentid, children);
                }
            }
            HashSet<Integer> visited = new HashSet<>();
            helper(kill, map, visited, res);
            return res;
        }

        private void helper(int kill, HashMap<Integer, List<Integer>> map, HashSet<Integer> visited, List<Integer> res){
            if(visited.contains(kill)){
                return;
            }
            visited.add(kill);
            res.add(kill);
            for(Integer child : map.getOrDefault(kill, new ArrayList<>())){
                helper(child, map, visited, res);
            }
        }
    }

}
