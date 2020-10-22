package Bloomberg;

public class lt450deleteNode {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        /*
        delete node in BST
        找
        1.要删的节点是左边还是右边，还是root
        删
        1.当前是leaf，那么直接变null
        2. 左不空，右为空，左子树接过来
        2.需要找一个node替换当前root
            1. 左子树中的最大值
            2. 右子树的最小值

        */
        public TreeNode deleteNode(TreeNode root, int key) {
            if(root == null){
                return null;
            }
            //find node
            if(root.val < key){
                //update 新的右子树
                root.right = deleteNode(root.right, key);
            }
            else if(root.val > key){
                //update 新的左子树
                root.left = deleteNode(root.left, key);
            }else{
                if(root.left == null && root.right == null){
                    root = null;
                }
                else if(root.left != null && root.right == null){
                    root = root.left;
                }
                else if(root.right != null && root.left == null){
                    root = root.right;
                }else{
                    int rightMin = findRightMin(root.right);
                    root.val = rightMin;
                    root.right = deleteNode(root.right, rightMin);
                }
            }
            return root;
        }


        public int findRightMin(TreeNode root){
            if(root.left == null){
                return root.val;
            }
            return findRightMin(root.left);
        }
    }
}
