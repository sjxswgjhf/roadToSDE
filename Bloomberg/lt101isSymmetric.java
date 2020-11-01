package Bloomberg;

import java.util.LinkedList;
import java.util.Queue;

public class lt101isSymmetric {
    /*
    这题把root当特例处理，然后再用left，right两个node当input去处理
    */
    class Solution {
        public boolean isSymmetric(TreeNode root) {
            if(root == null){
                return true;
            }
            return isSymmetric(root.left, root.right);
        }

        private boolean isSymmetric(TreeNode left, TreeNode right){
            if(left == null && right == null){
                return true;
            }
            else if(left == null){
                return false;
            }
            else if(right == null){
                return false;
            }else{
                if(left.val == right.val){
                    return isSymmetric(left.left, right.right)&&isSymmetric(left.right, right.left);
                }else{
                    return false;
                }
            }
        }
    }

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
    class SolutionBFS {
        public boolean isSymmetric(TreeNode root) {
            if(root == null){
                return true;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root.left);       //可能为null
            queue.add(root.right);      //可能为null
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0 ; i < queue.size(); i+=2){
                    TreeNode left = queue.poll();
                    TreeNode right = queue.poll();
                    if(left == null && right == null){
                        continue;
                    }
                    else if(left == null || right == null){
                        return false;
                    }
                    else if(left.val != right.val){
                        return false;
                    }
                    queue.add(left.left);
                    queue.add(right.right);
                    queue.add(left.right);
                    queue.add(right.left);
                }
            }

            return true;
        }
    }
}
