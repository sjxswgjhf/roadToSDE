package facebook;

public class isValidBST {

    class Solution {
        public boolean isValidBST(TreeNode root) {
            if(root == null){
                return true;
            }
            return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean helper(TreeNode root, long low, long high){
            if(root == null){
                return true;
            }
            if(root.val <= low || root.val >= high){
                return false;
            }
            return helper(root.left, low, root.val)&&helper(root.right, root.val, high);
        }
    }
}
