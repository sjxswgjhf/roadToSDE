package Bloomberg;

import java.util.ArrayList;
import java.util.List;

public class lt314verticalOrder {

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
        int leftMost = 0;
        int rightMost = 0;

        class Node{
            int val;
            int pos;
            public Node(int val, int pos){
                this.val = val;
                this.pos = pos;
            }
        }

        public List<List<Integer>> verticalOrder(TreeNode root) {

            List<List<Integer>> res = new ArrayList<>();
            if(root == null){
                return res;
            }
            List<List<Node>> list = new ArrayList<>();
            helper(root, list, 0, 0);
            int shift = Math.abs(leftMost);
            int total = Math.abs(leftMost) + rightMost + 1;
            for(int i = 0; i < total; i++){
                res.add(new ArrayList<>());
            }
            for(List<Node> l : list){
                for(Node node : l){
                    res.get(node.pos + shift).add(node.val);
                }
            }

            return res;
        }

        private void helper(TreeNode cur, List<List<Node>> list, int pos, int level){
            if(cur == null) {
                return;
            }
            if(list.size() == level){
                list.add(new ArrayList<>());
            }
            Node node = new Node(cur.val, pos);
            list.get(level).add(node);
            leftMost = Math.min(leftMost, pos);
            rightMost = Math.max(rightMost, pos);
            helper(cur.left, list, pos - 1, level + 1);
            helper(cur.right, list, pos + 1, level + 1);

        }
    }
}
