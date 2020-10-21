package Bloomberg;

import java.util.ArrayList;
import java.util.List;

public class lt662widthOfBinaryTree {


    /*
    这题我们去标记逐层每个点id，当前id取决于parent的id，左子树为pid*2,右子树为pid*2-1，那么我们就等于把这个tree当成了full binary tree
    来对待，这样我们之后就可以计算宽度
    然后使用level order来做，每层开始的时候去记录leftmost的id，然后每次都计算下max，right-left+1，最后最大的width被保留
    */

    class Solution {
        int max;
        public int widthOfBinaryTree(TreeNode root) {
            if(root == null){
                return 0;
            }
            max = 0;
            List<Integer> list = new ArrayList<>();
            helper(root, 1, 0, list);
            return max;
        }

        private void helper(TreeNode node, int id, int level, List<Integer> list){
            if(node == null){
                return;
            }
            if(level == list.size()){
                list.add(id);
            }
            max = Math.max(id - list.get(level) + 1, max);
            helper(node.left, id * 2, level + 1, list);
            helper(node.right, id * 2 + 1, level + 1, list);

        }

    }
}
