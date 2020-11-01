package Bloomberg;

import java.util.ArrayList;
import java.util.List;

public class lt103zigzagLevelOrder {

    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
            if(level % 2 == 0){
                res.get(level).add(root.val);
            }else{
                res.get(level).add(0, root.val);
            }
            helper(res, level + 1, root.left);
            helper(res, level + 1, root.right);
        }
    }
}
