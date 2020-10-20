package Bloomberg;

import java.util.LinkedList;
import java.util.Queue;

public class lt993isCousins {

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
        public boolean isCousins(TreeNode root, int x, int y) {
            Queue<TreeNode> queue = new LinkedList<>();
            boolean findx = false;
            boolean findy = false;
            queue.add(root);
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    TreeNode node = queue.poll();
                    if((node.left != null && node.left.val == x) && (node.right != null && node.right.val == y)){
                        return false;
                    }
                    if((node.left != null && node.left.val == y) && (node.right != null && node.right.val == x)){
                        return false;
                    }
                    if(node.val == x){
                        findx = true;
                    }
                    if(node.val == y){
                        findy = true;
                    }
                    if(i == size - 1){
                        if(findx && findy){
                            return true;
                        }
                        else if(findx || findy){
                            return false;
                        }
                    }
                    if(node.left != null){
                        queue.add(node.left);
                    }
                    if(node.right != null){
                        queue.add(node.right);
                    }
                }
            }
            return false;
        }
    }

    class SolutionDFS {
        public boolean isCousins(TreeNode root, int x, int y) {
            int dx = depth(root, x, 0);
            int dy = depth(root, y, 0);
            if(dx != dy){
                return false;
            }
            TreeNode px = findParent(root, x);
            TreeNode py = findParent(root, y);
            return px.val == py.val ? false : true;
        }

        private int depth(TreeNode root, int x, int level){
            if(root == null){
                return 0;
            }
            if(root.val == x){
                return level;
            }
            int left = depth(root.left, x, level+1);
            return left == 0 ? depth(root.right, x, level+1) : left;
        }


        private TreeNode findParent(TreeNode node, int x){
            if(node == null){
                return null;
            }
            if((node.left != null && node.left.val == x) || (node.right != null && node.right.val == x)){
                return node;
            }
            TreeNode left = findParent(node.left, x);

            return left != null ? left : findParent(node.right, x);
        }
    }
}
