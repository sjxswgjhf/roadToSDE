package microsoft;

public class lowestCommonAncestor {

    public TreeNode lowestCommonAncestorRecursion(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(root.val < p.val && root.val < q.val){
            lowestCommonAncestorRecursion(root.right, p, q);
        }
        else if(root.val > p.val && root.val > q.val){
            lowestCommonAncestorRecursion(root.left, p, q);
        }
        return root;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null){
            if(root.val > p.val && root.val > q.val){
                root = root.left;
            }
            else if(root.val < p.val && root.val < q.val){
                root = root.right;
            }else{
                return root;
            }
        }
        return null;
    }
}
