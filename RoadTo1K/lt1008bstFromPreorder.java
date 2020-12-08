package RoadTo1K;

public class lt1008bstFromPreorder {

    class Solution {
        public TreeNode bstFromPreorder(int[] preorder) {
            return helper(preorder, 0, preorder.length - 1);
        }

        private TreeNode helper(int[] preorder, int l, int r){
            if(l > r){
                return null;
            }
            if(l == r){
                return new TreeNode(preorder[l]);
            }
            TreeNode root = new TreeNode(preorder[l]);
            int idx = l;
            for(int i = l + 1; i <= r; i++){
                if(preorder[i] > preorder[l]){
                    break;
                }else{
                    idx = i;
                }
            }
            root.left = helper(preorder, l + 1, idx);
            root.right = helper(preorder, idx + 1, r);
            return root;
        }
    }
}
