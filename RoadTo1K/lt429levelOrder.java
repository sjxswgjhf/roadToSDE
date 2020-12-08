package RoadTo1K;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lt429levelOrder {

// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

    class Solution {
        /*
        BFS
        */
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> res = new ArrayList<>();
            if(root == null){
                return res;
            }
            Queue<Node> queue = new LinkedList<>();
            int level = 0;
            queue.add(root);
            while(!queue.isEmpty()){
                int size = queue.size();
                res.add(new ArrayList<>());
                for(int i = 0 ; i < size; i++){
                    Node node = queue.poll();
                    res.get(level).add(node.val);
                    for(Node child : node.children){
                        queue.add(child);
                    }
                }
                level++;
            }
            return res;
        }
    }
}
