package Bloomberg;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class lt173BSTIterator {

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
    class BSTIterator {

        Stack<TreeNode> stack;
        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            helper(root);
        }

        private void helper(TreeNode root){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode leftmost = stack.pop();
            //难点，当前的右边不是空的话，我们要把右边的所有左子树加到stack里面
            if(leftmost.right != null){
                helper(leftmost.right);
            }
            return leftmost.val;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }

    class BSTIteratorNSpace {

        Queue<Integer> queue;
        public BSTIteratorNSpace(TreeNode root) {
            queue = new LinkedList<>();
            helper(root);
        }

        private void helper(TreeNode root){
            if(root == null){
                return;
            }
            helper(root.left);
            queue.add(root.val);
            helper(root.right);
        }

        /** @return the next smallest number */
        public int next() {
            return queue.poll();
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !queue.isEmpty();
        }
    }
}
