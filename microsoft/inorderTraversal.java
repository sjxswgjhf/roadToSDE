package microsoft;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class inorderTraversal {

    public class Solution {
        public List < Integer > inorderTraversal(TreeNode root) {
            List < Integer > res = new ArrayList < > ();
            Stack< TreeNode > stack = new Stack < > ();
            TreeNode curr = root;
            while (curr != null || !stack.isEmpty()) {
                while (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }
                curr = stack.pop();
                res.add(curr.val);
                curr = curr.right;
            }
            return res;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        helper(root, res);
        return res;
    }

    private void helper(TreeNode node, List<Integer> res){
        if(node == null){
            return;
        }
        helper(node.left, res);
        res.add(node.val);
        helper(node.right, res);
    }

}
