package Bloomberg;

import java.util.ArrayList;
import java.util.List;

public class lt199rightSideView {

    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if(root == null){
                return res;
            }
            helper(root, res, 0);
            return res;
        }

        private void helper(TreeNode root, List<Integer> res, int level){
            if(root == null){
                return;
            }
            if(res.size() == level){
                res.add(root.val);
            }
            helper(root.right, res, level + 1);
            helper(root.left, res, level + 1);
        }
    }
}
