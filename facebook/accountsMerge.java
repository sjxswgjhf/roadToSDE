package facebook;

import java.util.*;

public class accountsMerge {


    class Solution {
        /*
        这题其实蛮难的
        解题思路，因为name不是key了，所以要用email来做，一个是email对应的user name，还有就是建立graph，一个无向图，通过无向图来定义同一个账户下的所有email
        */
        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            HashMap<String, HashSet<String>> graph = new HashMap<>();
            HashMap<String, String> emailToName = new HashMap<>();
            for(List<String> account : accounts){
                String name = account.get(0);
                //build email graph
                for(int i = 1; i < account.size(); i++){
                    String email = account.get(i);
                    emailToName.put(email, name);
                    if(!graph.containsKey(email)){
                        graph.put(email, new HashSet<>());
                    }
                    //connect adjecent email
                    if(i != 1){
                        graph.get(email).add(account.get(i - 1));
                        graph.get(account.get(i-1)).add(email);
                    }
                }
            }
            List<List<String>> res = new ArrayList<>();
            HashSet<String> visited = new HashSet<>();
            for(String email : emailToName.keySet()){
                String name = emailToName.get(email);
                if(!visited.contains(email)){

                    visited.add(email);
                    List<String> list = new ArrayList<>();
                    dfs(graph, email, list, visited);
                    Collections.sort(list);
                    list.add(0, name);
                    res.add(list);
                }
            }
            return res;
        }

        private void dfs(HashMap<String, HashSet<String>> graph, String email, List<String> list, HashSet<String> visited){
            list.add(email);
            for(String neighbor : graph.get(email)){
                if(!visited.contains(neighbor)){
                    visited.add(neighbor);
                    dfs(graph, neighbor, list, visited);
                }
            }
        }
    }
}
