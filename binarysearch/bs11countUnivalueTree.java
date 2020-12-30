package binarysearch;

public class bs11countUnivalueTree {

  public class Tree {
        int val;
        Tree left;
        Tree right;
      }

    class Solution {
        int res = 0;
        public int solve(Tree root) {
            if(root == null){
                return 0;
            }
            helper(root);
            return res;
        }

        private boolean helper(Tree root){
            if(root == null){
                return true;
            }
            if(root.left == null && root.right == null){
                res += 1;
                return true;
            }
            boolean left = helper(root.left);
            boolean right = helper(root.right);
            /*
            当前左右都是true的时候，就两种情况是false，
            1. 左边不为空，但是左边的值等于root
            2. 右边不为空，但是右边的值等于root
             */
            if(left && right){
                if(root.left != null && root.val != root.left.val){
                    return false;
                }
                if(root.right != null && root.val != root.right.val){
                    return false;
                }
                res += 1;
                return true;
            }
            return false;
        }
    }
}
