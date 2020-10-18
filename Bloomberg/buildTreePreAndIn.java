package Bloomberg;

import java.util.HashMap;

public class buildTreePreAndIn {



    class Solution {
        int[] preorder;
        int[] inorder;
        HashMap<Integer, Integer> map = new HashMap<>();
        int preidx = 0;


        // preorder = [3,9,20,15,7]
// inorder = [9,3,15,20,7]
        private TreeNode buildTree(int l, int r){
            if(l > r){
                return null;
            }
            int rootval = preorder[preidx]; // 3 9
            preidx++;   // 0 1 2
            TreeNode node = new TreeNode(rootval); // 3 9 0
            int rootIdx = map.get(rootval); // 1
            node.left = buildTree(l, rootIdx - 1);  //0~0
            node.right = buildTree(rootIdx + 1, r); //2~4
            return node;
        }

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            this.preorder = preorder;
            this.inorder = inorder;
            for(int i = 0; i < inorder.length; i++){
                map.put(inorder[i], i);
            }
            return buildTree(0, preorder.length - 1);
        }
    }
}
