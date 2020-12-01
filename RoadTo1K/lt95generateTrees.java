package RoadTo1K;

import java.util.ArrayList;
import java.util.List;

public class lt95generateTrees {

    class Solution {
        public List<TreeNode> generateTrees(int n) {
            if(n == 0){
                return new ArrayList<>();
            }

            return generate(1, n);
        }
        /*
        a method generate all bst from l to r
        */
        private List<TreeNode> generate(int l, int r){
            List<TreeNode> list = new ArrayList<>();
            if(l > r){
                list.add(null);
                return list;
            }
            for(int i = l; i <= r; i++){
                for(TreeNode left : generate( l, i - 1)){
                    for(TreeNode right : generate(i + 1, r)){
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        root.right = right;
                        list.add(root);
                    }
                }
            }
            return list;
        }
    }
}
