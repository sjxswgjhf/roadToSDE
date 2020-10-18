package Bloomberg;

public class kthSmallest {

    class Solution {
        TreeNode res = null;
        int idx = 0;
        public int kthSmallest(TreeNode root, int k) {
            helper(root, k);
            return res.val;
        }

        private void helper(TreeNode root, int k){
            if(root == null){
                return;
            }
            helper(root.left, k);
            idx++;
            if(idx == k){
                res = root;
                return;
            }
            helper(root.right, k);
        }
    }
}
