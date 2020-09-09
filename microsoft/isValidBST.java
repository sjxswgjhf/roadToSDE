package microsoft;

public class isValidBST {

    public boolean isValidBST(TreeNode root){
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long min, long max){
        if(node == null){
            return true;
        }
        if(node.val >= max || node.val <= min){
            return false;
        }
        return isValidBST(node.left, min, node.val)&&isValidBST(node.right, node.val, max);
    }
}
