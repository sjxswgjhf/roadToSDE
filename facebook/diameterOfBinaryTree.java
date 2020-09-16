package facebook;

public class diameterOfBinaryTree {

    class Solution {
        int max = 0;
        public int diameterOfBinaryTree(TreeNode root) {
            helper(root);
            return max;
        }

        private int helper(TreeNode root){
            if(root == null){
                return 0;
            }
            int l = root.left == null ? 0 : helper(root.left) + 1;
            int r = root.right == null ? 0 : helper(root.right) + 1;
            max = Math.max(max, l + r);
            return Math.max(l, r);
//            int left = helper(root.left);
//            int right = helper(root.right);
//            max = Math.max(max, left + right);
//            return Math.max(left, right) + 1;
        }
    }
}
