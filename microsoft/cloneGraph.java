package microsoft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class cloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    class Solution {

        HashMap<Node, Node> finished = new HashMap<>();
        public Node cloneGraph(Node node) {
            if(node == null){
                return null;
            }
            if(finished.containsKey(node)){
                return finished.get(node);
            }
            Node start = new Node(node.val, new ArrayList<>());
            finished.put(node, start);
            List<Node> list = node.neighbors;
            for(Node n : list){
                start.neighbors.add(cloneGraph(n));
            }

            return start;
        }
    }
}
