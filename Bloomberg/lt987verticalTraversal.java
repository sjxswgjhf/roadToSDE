package Bloomberg;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class lt987verticalTraversal {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {

        class Node{
            int val;
            int x;
            int y;
            public Node(int val, int x, int y){
                this.val = val;
                this.x = x;
                this.y = y;
            }
        }

        int leftMost = 0;
        int rightMost = 0;

        public List<List<Integer>> verticalTraversal(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.y != b.y ? a.y - b.y : (a.x == b.x ? a.val - b.val : a.x - b.x));
            helper(root, 0, 0, pq);
            int size = Math.abs(leftMost) + rightMost + 1;
            for(int i = 0; i < size; i++){
                res.add(new ArrayList<>());
            }
            int shift = Math.abs(leftMost);
            while(!pq.isEmpty()){
                Node node = pq.poll();
                List<Integer> cur = res.get(node.x + shift);
                cur.add(node.val);
            }
            return res;
        }

        private void helper(TreeNode root, int x, int y, PriorityQueue<Node> pq){
            if(root == null){
                return;
            }
            Node node = new Node(root.val, x, y);
            pq.add(node);
            leftMost = Math.min(leftMost, x);
            rightMost = Math.max(rightMost, x);
            helper(root.left, x - 1, y + 1, pq);
            helper(root.right, x + 1, y + 1, pq);
        }
    }
}
