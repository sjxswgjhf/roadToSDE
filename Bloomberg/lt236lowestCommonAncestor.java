package Bloomberg;

public class lt236lowestCommonAncestor {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
    /*
    这题的核心思想是返回空的还是不为空
    例如 5 0
    那么左子树5的subtree会返回left空，right为2，这时候5就返回2给3，说明3的left不为空
    然后右子树的1的subtree会返回left为0，右边为空，那么1就要返回0给3，这时候3的right不为空
    最后返回3

    例如6 7
    那么左子树5的subtree会返回left 6，然后去右边看，右边的2会因为7在left，所以返回7给5，这时候5发现left，right都不是空，那么就是自己是这个root了，返回给3
    3再去右边看。发现返回为空，那么就应该返回left

    所以最后的结果取决于left是不是为空，是的话返回right，
    或者right是不是为空，是的话返回left
    最后如果两边都不为空就是root

     这题有点类似反证法的意思，就是一端没找到，那么肯定就是另一端了。我返回另一边就行了。但是因为是recursion，所以两边都会返回一个情况给root，然后root根据两边的情况判断出最后的结果
    */

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null || root == p || root == q){
                return root;
            }
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p , q);
            if(left == null){
                return right;
            }
            if(right == null){
                return left;
            }
            return root;
        }
    }
}
