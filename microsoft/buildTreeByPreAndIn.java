package microsoft;

import java.util.HashMap;

public class buildTreeByPreAndIn {



    //用preorder去找root,用inorder去找左右subtree，所以需要用到hashmap去记录当前值的idx
    class Solution {
        int pre_idx = 0;
        int[] preorder;
        int[] inorder;
        HashMap<Integer, Integer> hashmap = new HashMap<>();

        private TreeNode helper(int left, int right){
            if(left == right){
                return null;
            }
            int rootval = preorder[pre_idx];
            // pick up pre_idx element as a root
            TreeNode root = new TreeNode(rootval);
            pre_idx++;
            // root splits inorder list
            // into left and right subtrees
            int idx = hashmap.get(root.val);
            root.left = helper(left, idx);
            root.right = helper(idx + 1, right);
            return root;

        }

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            this.preorder = preorder;
            this.inorder = inorder;
            int idx = 0;
            for(int v : inorder){
                hashmap.put(v, idx++);
            }
            return helper(0, preorder.length);
        }
    }
}
