package Bloomberg2;

public class lt98isValidBST {

    class Solution {
        public boolean isValidBST(TreeNode root) {
            if(root == null){
                return true;
            }
            if(root.left == null && root.right == null){
                return true;
            }
            return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean isValidBST(TreeNode root, Long left, Long right){
            if(root == null){
                return true;
            }
            if(root.val <= left || root.val >= right){
                return false;
            }
            return isValidBST(root.left, left, (long)root.val)&&isValidBST(root.right, (long)root.val, right);
        }
    }
}
