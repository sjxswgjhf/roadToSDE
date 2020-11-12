package Bloomberg2;

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

        class Node{
            int val;
            int pos;
            int level;
            public Node(int val, int pos, int level){
                this.val = val;
                this.pos = pos;
                this.level = level;
            }
        }

        int leftMost = 0;
        int rightMost = 0;
        public List<List<Integer>> verticalOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if(root == null){
                return res;
            }
            List<List<Node>> list = new ArrayList<>();
            helper(root, list, 0, 0);
            int shift = Math.abs(leftMost);
            int total = shift + rightMost + 1;
            for(int i = 0; i < total; i++){
                res.add(new ArrayList<>());
            }
            //add node level by level instead of sort the node
            for(List<Node> l : list){
                for(Node node : l){
                    res.get(node.pos + shift).add(node.val);
                }
            }
            return res;
        }

        private void helper(TreeNode root, List<List<Node>> list, int pos, int level){
            if(root == null){
                return;
            }
            Node node = new Node(root.val, pos, level);
            if(list.size() == level){
                list.add(new ArrayList<>());
            }
            list.get(level).add(node);
            leftMost = Math.min(leftMost, pos);
            rightMost = Math.max(rightMost, pos);
            helper(root.left, list, pos - 1, level + 1);
            helper(root.right, list, pos + 1, level + 1);
        }
    }
}
