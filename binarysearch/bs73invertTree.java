package binarysearch;

public class bs73invertTree {

    class Solution {
        public Tree solve(Tree root) {
            if(root == null){
                return null;
            }
            if(root.left != null && root.right != null){
                Tree left = root.left;
                root.left = root.right;
                root.right = left;
                solve(root.left);
                solve(root.right);
                return root;
            }
            else if(root.left != null){
                root.right = root.left;
                root.left = null;
                solve(root.right);
                return root;
            }
            else if(root.right != null){
                root.left = root.right;
                root.right = null;
                solve(root.left);
                return root;
            }else{
                return root;
            }
        }
    }
}
