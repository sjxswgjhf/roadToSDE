package Bloomberg;

import java.util.ArrayList;
import java.util.List;

public class lt102levelOrder {

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if(root == null){
                return res;
            }
            helper(res, 0, root);
            return res;
        }

        private void helper(List<List<Integer>> res, int level, TreeNode root){
            if(root == null){
                return;
            }
            if(res.size() == level){
                res.add(new ArrayList<>());
            }
            res.get(level).add(root.val);
            helper(res, level + 1, root.left);
            helper(res, level + 1, root.right);
        }
    }
}
