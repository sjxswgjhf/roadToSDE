package Bloomberg;

public class l129sumNumbers {

    class Solution {
        int res = 0;
        public int sumNumbers(TreeNode root) {

            helper(root, 0);
            return res;
        }

        public void helper(TreeNode root, int cur){
            if(root == null){
                return;
            }
            if(root.left == null && root.right == null){
                cur = cur * 10 + root.val;
                res += cur;
                return;
            }
            cur = cur * 10 + root.val;
            helper(root.left, cur);
            helper(root.right, cur);
        }
    }
}
