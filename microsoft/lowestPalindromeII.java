package microsoft;

import java.util.LinkedList;
import java.util.Queue;

public class lowestPalindromeII {

    class SolutionII {

        private TreeNode ans;

        public SolutionII() {
            // Variable to store LCA node.
            this.ans = null;
        }

        private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {

            // If reached the end of a branch, return false.
            if (currentNode == null) {
                return false;
            }

            // Left Recursion. If left recursion returns true, set left = 1 else 0
            int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;

            // Right Recursion
            int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;

            // If the current node is one of p or q
            int mid = (currentNode == p || currentNode == q) ? 1 : 0;


            // If any two of the flags left, right or mid become True
            if (mid + left + right >= 2) {
                this.ans = currentNode;
            }

            // Return true if any one of the three bool values is True.
            return (mid + left + right > 0);
        }

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // Traverse the tree
            this.recurseTree(root, p, q);
            return this.ans;
        }
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
