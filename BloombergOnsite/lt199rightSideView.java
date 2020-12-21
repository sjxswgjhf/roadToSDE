package BloombergOnsite;

import java.util.ArrayList;
import java.util.List;

public class lt199rightSideView {

    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            helper(root, 0, res);
            return res;
        }

        private void helper(TreeNode root, int level, List<Integer> res){
            if(root == null){
                return;
            }
            if(level == res.size()){
                res.add(root.val);
            }
            helper(root.right, level + 1, res);
            helper(root.left, level + 1, res);
        }
    }
}
