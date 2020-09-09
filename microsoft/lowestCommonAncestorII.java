package microsoft;

import java.util.LinkedList;
import java.util.Queue;

public class lowestCommonAncestorII {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right,p, q);
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        return root;
    }


    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null){
                return null;
            }
            boolean leftContains = check(root.left, p, q);
            boolean rightContains = check(root.right, p, q);
            if(leftContains){
                return lowestCommonAncestor(root.left,p, q);
            }
            else if(rightContains){
                return lowestCommonAncestor(root.right, p, q);
            }
            else{
                return root;
            }
        }

        private boolean check(TreeNode node, TreeNode p, TreeNode q){
            if(node == null){
                return false;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(node);
            boolean findp = false;
            boolean findq = false;
            while(!queue.isEmpty()){
                int size = queue.size();
                while(size > 0){
                    TreeNode n = queue.poll();
                    if(n == p){
                        findp = true;
                    }
                    else if(n == q){
                        findq = true;
                    }
                    if(findp && findq){
                        return true;
                    }
                    if(n.left != null){
                        queue.add(n.left);
                    }
                    if(n.right != null){
                        queue.add(n.right);
                    }
                    size--;
                }
            }
            return false;
        }
    }
}
