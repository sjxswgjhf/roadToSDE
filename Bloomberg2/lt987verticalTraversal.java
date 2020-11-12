package Bloomberg2;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class lt987verticalTraversal {


    class Solution {
        int leftMost = 0;
        int rightMost = 0;
        class Node{
            int val;
            int pos;
            int level;
            public Node(int v, int p, int level){
                this.val = v;
                this.pos = p;
                this.level = level;
            }
        }
        public List<List<Integer>> verticalTraversal(TreeNode root) {
            if(root == null){
                return new ArrayList<>();
            }
            List<List<Integer>> res = new ArrayList<>();
            PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.level != b.level ? a.level - b.level : (a.pos == b.pos ? a.val - b.val : a.pos - b.pos));
            helper(root, pq, 0, 0);
            int shift = Math.abs(leftMost);
            int total = shift + rightMost + 1;
            for(int i = 0; i < total; i++){
                List<Integer> l = new ArrayList<>();
                res.add(l);
            }
            while(!pq.isEmpty()){
                Node node = pq.poll();
                int idx = node.pos + shift;
                res.get(idx).add(node.val);
            }
            return res;
        }

        private void helper(TreeNode root, PriorityQueue<Node> pq, int pos, int level){
            if(root == null){
                return;
            }
            Node node = new Node(root.val, pos, level);
            pq.add(node);
            leftMost = Math.min(leftMost, pos);
            rightMost = Math.max(rightMost, pos);
            helper(root.left, pq, pos - 1, level + 1);
            helper(root.right, pq, pos + 1, level + 1);
        }
    }
}
