package RoadTo1K;

public class lt156updasideDownBinaryTree {

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
        /*
              5                 2           5                        2
           /    \              / \         /  \                   /    \
          3      7      =>    4   3       3    7        =>       4      3
         / \    / \              / \          / \                      / \
        2   4  6   8            nl  nl        6  8                    7    2
                                                                     /\    /\
                                                                    6  8  nl nl
        */
        public TreeNode upsideDownBinaryTree(TreeNode root) {
            //this is for null input
            if(root == null){
                return root;
            }
            //this is for left leaf node, 我们需要有个left child去搭建新的tree
            if(root.left == null){
                return root;
            }
            TreeNode newRoot = upsideDownBinaryTree(root.left);
            root.left.left = root.right;
            root.left.right = root;
            root.left = null;
            root.right = null;
            return newRoot;
        }
    }
}
