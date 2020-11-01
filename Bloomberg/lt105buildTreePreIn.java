package Bloomberg;

import java.util.HashMap;

public class lt105buildTreePreIn {

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
    preorder = [3,9,20,15,7]
    inorder = [9,3,15,20,7]

    prorder是每个root
    inorder区分左右substree

    */

        int preidx;
        HashMap<Integer, Integer> map;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            map = new HashMap<>();
            preidx = 0;
            for(int i = 0; i< inorder.length; i++){
                map.put(inorder[i], i);
            }
            return helper(preorder, 0, preorder.length - 1);
        }

        private TreeNode helper(int[] preorder, int s, int e){
            if(s > e){
                return null;
            }
            TreeNode root = new TreeNode(preorder[preidx]);
            int idx = map.get(root.val);
            preidx++;
            root.left = helper(preorder, s, idx - 1);
            root.right = helper(preorder, idx + 1, e);
            return root;
        }
    }
}
