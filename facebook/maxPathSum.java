package facebook;

public class maxPathSum {

    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }
    private int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        int sum = root.val + left + right;
        max = Math.max(sum, max);
        return Math.max(left, right) + root.val;
    }

}
