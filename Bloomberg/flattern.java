package Bloomberg;

public class flattern {


    class SolutionIterative{
        public void flatten(TreeNode root){
            if(root == null){
                return;
        }
            TreeNode node = root;
            /*
            iterative的思想就是先把右子树接到左子树的最右边，然后把root左边接到root右边左边为null，然后一直处理右边，
            每遇到一个右子树的左边不为空，那么我们就把这个右子树的右边接到左边的最右边，一直这样做
             */
            while(node != null){
                if(node.left != null){
                    TreeNode rightMost = node.left;
                    while(rightMost.right != null){
                        rightMost = rightMost.right;
                    }
                    rightMost.right = node.right;
                    node.right = node.left;
                    node.left = null;
                }
                node = node.right;
            }
        }
    }

    class SolutionRecursion {
        TreeNode prev;
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
}
