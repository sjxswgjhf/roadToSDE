package RoadTo1K;

public class lt897increasingBST {

    /*
    这题O(N)space的话很简单，直接inorder放到list里面，然后再loop one by one
    但是可以用recursion来做，O(h) space
    我们需要一个node去记录我们先前的那个node，所以需要一个global val，然后我们又要知道先前的node，这个先前node又是变化的，
    初始的时候我们需要一个dummy node去保证这个head，然后用一个global cur去记录这个prev的变化，然后做inorder，
    当在左边的时候，我们的cur是dummy，node是leftmost，那么node.left设为null，断掉先前的链接，然后接到cur的right，然后把cur变成node，node就是下一层的
    prev，
     */

    class Solution {
        TreeNode cur;
        public TreeNode increasingBST(TreeNode root) {
            TreeNode dummy = new TreeNode(0);
            cur = dummy;
            inorder(root);
            return dummy.right;
        }

        private void inorder(TreeNode node){
            if(node == null){
                return;
            }
            inorder(node.left);
            node.left = null;
            cur.right = node;
            cur = node;
            inorder(node.right);
        }

    }
}
