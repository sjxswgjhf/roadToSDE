package BloombergOnsite;

import java.util.ArrayList;
import java.util.List;

public class lt102levelOrderTraversal {

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if(root == null){
                return res;
            }
            traversal(root, 0, res);
            return res;
        }

        private void traversal(TreeNode root, int level, List<List<Integer>> res){
            if(root == null){
                return;
            }
            if(res.size() == level){
                res.add(new ArrayList<>());
            }
            res.get(level).add(root.val);
            traversal(root.left, level + 1, res);
            traversal(root.right, level + 1, res);
        }
    }

}
