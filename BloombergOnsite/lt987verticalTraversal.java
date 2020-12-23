package BloombergOnsite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
            int level;
            int pos;
            public Node(int val, int level, int pos){
                this.val = val;
                this.level = level;
                this.pos = pos;
            }
        }

        int leftMost = 0;
        int rightMost = 0;
        public List<List<Integer>> verticalTraversal(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if(root == null){
                return res;
            }
            List<List<Node>> list = new ArrayList<>();
            helper(root, 0, 0, list);
            int total = Math.abs(leftMost) + rightMost + 1;
            int shift = Math.abs(leftMost);
            for(int i = 0; i < total; i++){
                res.add(new ArrayList<>());
            }

            for(List<Node> l : list){
                Collections.sort(l,(a,b)->a.val-b.val);
                for(Node node : l){
                    res.get(node.pos + shift).add(node.val);
                }

            }
            return res;
        }

        private void helper(TreeNode root, int level, int pos, List<List<Node>> list){
            if(root == null){
                return;
            }
            if(list.size() == level){
                list.add(new ArrayList<>());
            }
            leftMost = Math.min(leftMost, pos);
            rightMost = Math.max(rightMost, pos);
            Node node = new Node(root.val, level, pos);
            list.get(level).add(node);
            helper(root.left, level + 1, pos - 1, list);
            helper(root.right, level + 1, pos + 1, list);
        }

    }
}
