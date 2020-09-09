package microsoft;

import java.util.ArrayList;
import java.util.List;

public class zigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, res, 0);
        return res;
    }

    private void helper(TreeNode root, List<List<Integer>> res, int level){
        if(root == null){
            return;
        }
        if(res.size() == level){
            res.add(new ArrayList<>());
        }
        List<Integer> list = res.get(level);
        if(level % 2 == 0){
            list.add(root.val);
        }else{
            list.add(0, root.val);
        }
        helper(root.left, res, level+1);
        helper(root.right, res, level + 1);
    }

}
