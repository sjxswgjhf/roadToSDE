package binarysearch;

public class bs78mergeingBinaryTree {

    class Solution {
        public Tree solve(Tree node0, Tree node1) {
            if(node0 == null){
                return node1;
            }
            if(node1 == null){
                return node0;
            }
            Tree node = new Tree(node0.val + node1.val);
            node.left = solve(node0.left, node1.left);
            node.right = solve(node0.right, node1.right);
            return node;
        }
    }

}
