package facebook;

public class flattenbinarytree {

    class SolutionNiuBi {
        public void flatten(TreeNode root) {
            if(root == null){
                return;
            }
            TreeNode node = root;
            while(node != null){
                if(node.left != null){
                    //当node的左边不为空的时候，先到左边的最右边，然后把node的右边接到这个地方，然后把node的right变成这个left，然后left=null，再传node到node的右边，直到为null
                    TreeNode rightmost = node.left;
                    while(rightmost.right != null){
                        rightmost = rightmost.right;
                    }
                    rightmost.right = node.right;
                    node.right = node.left;
                    node.left = null;
                }
                node = node.right;
            }
        }
    }

    class SolutionSimple {
        TreeNode prev = null;
        public void flatten(TreeNode root) {
            if(root == null){
                return;
            }
            flatten(root.right);
            flatten(root.left);
            root.right = prev;
            root.left = null;
            prev = root;
        }
    }

    class Solution {
        public void flatten(TreeNode root) {
            helper(root);
        }

        private TreeNode helper(TreeNode root){
            if(root == null){
                return null;
            }
            if(root.left == null && root.right == null){
                return root;
            }
            TreeNode left = helper(root.left);
            TreeNode right = helper(root.right);
            if(left != null){
                left.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            return right == null ? left : right;
        }
    }
}
