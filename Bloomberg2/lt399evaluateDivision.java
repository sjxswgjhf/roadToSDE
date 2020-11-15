package Bloomberg2;

import java.util.*;

public class lt399evaluateDivision {

    class Solution {

    /*

    a / b = 2.0
    b / c = 3.0
    a / c = 6.0

    a=>b => c
    dfs(a.child):
        dfs(b.child):
            got c return b/c
        return 3.0
    return 2* 3.0 = 6

    c => b => a
    dfs(c.child):
        dfs(b.child):
            got a return 0.5
        return 0.5
    return 1/3*0.5 = 1/6

    */

        class Node{
            String str;
            double val;
            public Node(String str, double val){
                this.str = str;
                this.val = val;
            }
        }

        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            HashMap<String, List<Node>> map = new HashMap<>();
            for(int i = 0 ; i < values.length; i++){
                List<String> equation = equations.get(i);
                double val = values[i];
                String up = equation.get(0);
                String bot = equation.get(1);
                Node node = new Node(bot, val);
                List<Node> list = map.getOrDefault(up, new ArrayList<>());
                list.add(node);
                map.put(up, list);
                Node node2 = new Node(up, 1.0 / val);
                List<Node> list2 = map.getOrDefault(bot, new ArrayList<>());
                list2.add(node2);
                map.put(bot, list2);
            }
            double[] res = new double[queries.size()];
            int idx = 0;
            for(List<String> query : queries){
                double val = help(map, query.get(0), query.get(1), new HashSet<>());
                res[idx++] = val;
            }
            return res;
        }

        private double help(HashMap<String, List<Node>> map, String cur, String target, HashSet<String> visited){
            if(!map.containsKey(cur)){
                return -1.0;
            }
            if(cur.equals(target)){
                return 1.0;
            }
            if(visited.contains(cur)){
                return -1.0;
            }
            List<Node> list = map.get(cur);
            visited.add(cur);
            for(Node node : list){
                double res = help(map, node.str, target, visited);
                if(res != -1.0){
                    return res * node.val;
                }
            }
            return -1.0;
        }
    }
}
