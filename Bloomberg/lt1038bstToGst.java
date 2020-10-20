package Bloomberg;

public class lt1038bstToGst {

    class Solution {

        int sum = 0;
        public TreeNode bstToGst(TreeNode root) {
            helper(root);
            return root;
        }

        private void helper(TreeNode node){
            if(node == null){
                return;
            }
            helper(node.right);
            int tmp = node.val;
            node.val += sum;
            sum += tmp;
            helper(node.left);
        }
    }
}
