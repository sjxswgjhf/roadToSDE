package Bloomberg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class lt399calcEquation {

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

        HashMap<String, List<Node>> graph;
        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            double[] res = new double[queries.size()];
            graph = new HashMap<>();
            buildGraph(equations, values);
            int idx = 0;
            for(List<String> query :queries){
                if(!graph.containsKey(query.get(0)) || !graph.containsKey(query.get(1))){
                    res[idx] = -1.0;
                }else{
                    HashSet<String> visited = new HashSet<>();
                    double val = dfs(query.get(0), query.get(1), visited);
                    res[idx] = val;
                }
                idx++;

            }
            return res;
        }

        private double dfs(String a, String b, HashSet<String> visited){
            if(a.equals(b)){
                return 1.0;
            }
            visited.add(a);
            List<Node> children = graph.get(a);
            for(int i = 0; i < children.size(); i++){
                Node child = children.get(i);
                if(!visited.contains(child.str)){
                    double res = dfs(child.str, b, visited);
                    if(res != -1.0){
                        return res * child.val;
                    }
                }
            }
            return -1;
        }

        private void buildGraph(List<List<String>> equations, double[] values){
            for(int i = 0; i < equations.size(); i++){
                double val = values[i];
                List<String> equation = equations.get(i);
                // a -> b = val.  b->a = 1/val
                Node nodeb = new Node(equation.get(1), val);
                Node nodea = new Node(equation.get(0), 1 / val);
                List<Node> g1 = graph.getOrDefault(equation.get(0), new ArrayList<>());
                List<Node> g2 = graph.getOrDefault(equation.get(1), new ArrayList<>());
                g1.add(nodeb);
                g2.add(nodea);
                graph.put(equation.get(0), g1);
                graph.put(equation.get(1), g2);
            }

        }
    }
}
