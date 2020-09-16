package facebook;

import java.util.ArrayList;
import java.util.List;

public class binaryTreePaths {

    class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> res = new ArrayList<>();
            buildpath(root, "", res);
            return res;
        }

        private void buildpath(TreeNode node, String path, List<String> res){
            if(node == null){
                return;
            }
            if(node.left == null && node.right == null){
                path += node.val;
                res.add(path);
            }
            if(node.left != null){
                path += node.val + "->";
                buildpath(node.left, path, res);
            }
            if(node.right != null){
                path += node.val + "->";
                buildpath(node.right, path, res);
            }
        }
    }
}
