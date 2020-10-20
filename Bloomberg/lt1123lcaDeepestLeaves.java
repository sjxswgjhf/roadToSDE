package Bloomberg;

public class lt1123lcaDeepestLeaves {

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
        先计算深度，然后根据深度，我们去做recursion，逐层往下，到倒数第二层的时候，我们看left跟right的返回值，如果都不是空，
        那么说明左右都有，返回当前root，如果左边为空，说明最深的只有右边有，返回右边，反之返回左边。
        */
        public TreeNode lcaDeepestLeaves(TreeNode root) {
            int depth = depth(root);
            return helper(root, depth);
        }

        private int depth(TreeNode root){
            if(root == null){
                return 0;
            }
            int l = depth(root.left);
            int r = depth(root.right);
            return Math.max(l, r) + 1;
        }

        private TreeNode helper(TreeNode root, int depth){
            if(root == null){
                return null;
            }
            if(depth == 1){
                return root;
            }
            TreeNode left = helper(root.left, depth - 1);
            TreeNode right = helper(root.right, depth - 1);
            if(left != null && right != null){
                return root;
            }
            return left == null ? right : left;

        }
    }
}
