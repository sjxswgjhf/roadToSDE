package facebook;

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

        HashMap<Node, Node> visited = new HashMap<>();
        public Node cloneGraph(Node node) {
            if(node == null){
                return null;
            }
            if(visited.containsKey(node)){
                return visited.get(node);
            }
            Node cur = new Node(node.val);
            visited.put(node, cur);
            List<Node> neigh = node.neighbors;
            for(Node n : neigh){
                cur.neighbors.add(cloneGraph(n));
            }
            return cur;
        }
    }
}
