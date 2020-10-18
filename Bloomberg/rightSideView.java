package Bloomberg;

import java.util.ArrayList;
import java.util.List;

public class rightSideView {

    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if(root == null){
                return res;
            }
            rightSideView(root, res, 0);
            return res;
        }

        private void rightSideView(TreeNode node, List<Integer> res, int level){
            if(node == null){
                return;
            }
            if(res.size() == level){
                res.add(node.val);
            }
            rightSideView(node.right, res, level+1);
            rightSideView(node.left, res, level+1);
        }
    }
}
