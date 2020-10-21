package Bloomberg;

import java.util.*;

public class lt721accountMerge {

    class Solution {
    /*
    1. build email undirection graph
    2. build result, avoid vistied
    */

        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            HashMap<String, List<String>> graph = new HashMap<>();
            HashMap<String, String> map = new HashMap<>();
            List<List<String>> res = new ArrayList<>();
            for(List<String> account : accounts){
                String name = account.get(0);
                for(int i = 1; i < account.size(); i++){
                    map.put(account.get(i), name);
                    for(int j = i + 1; j < account.size(); j++){
                        String email1 = account.get(i);
                        String email2 = account.get(j);
                        List<String> l1 = graph.getOrDefault(email1, new ArrayList<>());
                        List<String> l2 = graph.getOrDefault(email2, new ArrayList<>());
                        l1.add(email2);
                        l2.add(email1);
                        graph.put(email1, l1);
                        graph.put(email2, l2);
                    }
                }
            }
            HashSet<String> visited = new HashSet<>();
            for(String email : map.keySet()){
                if(visited.contains(email)){
                    continue;
                }
                Queue<String> queue = new LinkedList<>();
                queue.add(email);
                List<String> list = new ArrayList<>();
                while(!queue.isEmpty()){
                    int size = queue.size();
                    for(int i = 0; i < size; i++){
                        String e = queue.poll();
                        if(visited.contains(e))
                            continue;
                        list.add(e);
                        visited.add(e);
                        List<String> neigh = graph.getOrDefault(e, new ArrayList<>());
                        for(String nei : neigh){
                            queue.add(nei);
                        }
                    }
                }
                Collections.sort(list);
                list.add(0, map.get(email));
                res.add(list);
            }
            return res;
        }
    }
}
