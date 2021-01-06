package binarysearch;

public class bs317symmetricBinaryTree {
    class Solution {
        public boolean solve(Tree root) {
            if(root == null){
                return true;
            }

            return  helper(root, root);
        }

        private boolean helper(Tree root1, Tree root2){
            if(root1 == null && root2 == null){
                return true;
            }
            else if(root1 != null && root2 == null){
                return false;
            }
            else if(root1 == null && root2 != null){
                return false;
            }else{
                if(root1.val == root2.val){
                    boolean left = helper(root1.left, root2.right);
                    boolean right = helper(root1.right, root2.left);
                    if(left && right){
                        return true;
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }
        }
    }
}
