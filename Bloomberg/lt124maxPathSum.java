package Bloomberg;

public class lt124maxPathSum {

    class Solution {
        int max = Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
            helper(root);
            return max;
        }

        private int helper(TreeNode root){
            if(root == null){
                return 0;
            }
            int left = Math.max(0, helper(root.left));
            int right = Math.max(0, helper(root.right));
            int cur = root.val + left + right;
            max = Math.max(cur, max);
            return Math.max(left, right) + root.val;
        }
    }
}
