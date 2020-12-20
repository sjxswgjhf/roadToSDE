package BloombergOnsite;

public class lt98isValidBST {
    class Solution {
        public boolean isValidBST(TreeNode root) {
            if(root == null){
                return true;
            }
            if(root.left == null && root.right == null){
                return true;
            }

            return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean helper(TreeNode root, long left, long right){
            if(root == null){
                return true;
            }
            if(root.val <= left || root.val >= right){
                return false;
            }
            return helper(root.left, left, root.val)&&helper(root.right, root.val, right);
        }
    }
}
