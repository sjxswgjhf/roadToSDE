package Bloomberg;

import java.util.ArrayList;
import java.util.List;

public class lt230kthSmallest {

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
    class Solution {

        int cur = 0;
        int ans = -1;
        public int kthSmallest(TreeNode root, int k) {
            helper(root.left, k);
            if(ans != -1){
                return ans;
            }
            if(k - cur == 1){
                return root.val;
            }
            cur++;
            helper(root.right, k);
            return ans;
        }

        private void helper(TreeNode root, int k){
            if(root == null){
                return;
            }
            helper(root.left, k);
            cur++;
            if(k== cur){
                ans = root.val;
            }
            helper(root.right,k);
        }
    }

    class SolutionNSpace {
        /*
        Naive: O(n)space
        */
        public int kthSmallest(TreeNode root, int k) {
            List<Integer> list = new ArrayList<>();
            helper(root, list);
            return list.get(k - 1);
        }

        private void helper(TreeNode root, List<Integer> list){
            if(root == null){
                return;
            }
            helper(root.left, list);
            list.add(root.val);
            helper(root.right, list);
        }
    }
}
