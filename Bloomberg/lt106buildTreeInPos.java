package Bloomberg;

import java.util.HashMap;

public class lt106buildTreeInPos {


/*
inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]

*/

    class Solution {

        int posIdx;
        HashMap<Integer, Integer> map;
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            map = new HashMap<>();
            posIdx = postorder.length - 1;
            for(int i = 0; i < inorder.length; i++){
                map.put(inorder[i], i);
            }
            return helper(postorder, 0, inorder.length - 1);
        }

        private TreeNode helper(int[] postorder, int s, int e){
            if(s > e){
                return null;
            }
            TreeNode root = new TreeNode(postorder[posIdx]);
            posIdx--;
            int idx = map.get(root.val);
            //2~4, idx = 1 + 1 =2, e = 4
            root.right = helper(postorder, idx + 1, e);
            //0 ~ 0
            root.left = helper(postorder, s, idx - 1);
            return root;
        }
    }
}
