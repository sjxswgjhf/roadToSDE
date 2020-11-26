package RoadTo1K;

public class lt700searchBST {
    class Solution {
        public TreeNode searchBST(TreeNode root, int val) {
            if(root == null){
                return root;
            }
            if(val == root.val){
                return root;
            }
            else if(val < root.val){
                return searchBST(root.left, val);
            }else{
                return searchBST(root.right, val);
            }
        }
    }
}
