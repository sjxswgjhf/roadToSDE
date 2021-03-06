package Bloomberg;

public class isValidBST {

    class Solution {
        public boolean isValidBST(TreeNode root) {
            if(root == null){
                return true;
            }
            return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean isValidBST(TreeNode root, long left, long right){
            if(root == null){
                return true;
            }
            if(root.val <= left){
                return false;
            }
            if(root.val >= right){
                return false;
            }
            return isValidBST(root.left, left, root.val)&&isValidBST(root.right, root.val, right);
        }
    }
}
