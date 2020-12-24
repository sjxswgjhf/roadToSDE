package BloombergOnsite;

import java.util.ArrayList;
import java.util.List;

public class lt1522diameterNTree {


// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;


    public Node() {
        children = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }

    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};


    class Solution {
        int res = 0;
        public int diameter(Node root) {
            if(root == null){
                return 0;
            }
            dfs(root);
            return res;
        }

        private int dfs(Node root){
            if(root == null){
                return 0;
            }
            List<Node> children = root.children;
            int max = 0;
            int secondMax = 0;
            for(Node child : children){
                int distance = dfs(child) + 1;
                if(distance > max){
                    secondMax = max;
                    max = distance;
                }
                else if(distance > secondMax){
                    secondMax = distance;
                }
            }
            res = Math.max(res, max + secondMax);
            return max;
        }
    }
}
