package Bloomberg;

public class lt98isValidBST {

    class Solution {
        public boolean isValidBST(TreeNode root) {
            if(root == null){
                return true;
            }
            return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean isValidBST(TreeNode root, long l, long r){
            if(root == null){
                return true;
            }
            if(root.val <= l || root.val >= r){
                return false;
            }
            return isValidBST(root.left, l, root.val)&&isValidBST(root.right, root.val, r);
        }
    }
}
