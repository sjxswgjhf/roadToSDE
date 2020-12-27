package BloombergOnsite;

import java.util.ArrayList;
import java.util.List;

public class lt257binaryTreePaths {

    class SolutionStringBuffer {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> res = new ArrayList<>();
            StringBuffer sb = new StringBuffer();
            helper(root, res, sb);
            return res;
        }

        private void helper(TreeNode root, List<String> res, StringBuffer path){
            if(root == null){
                return;
            }
            if(root.left == null && root.right == null){
                int tmp = path.length();
                path.append(root.val);
                // path += root.val;
                res.add(new String(path.toString()));
                path.setLength(tmp);
                return;
            }
            int len = path.length();
            path.append(root.val);
            path.append("->");
            helper(root.left, res, path);
            helper(root.right, res, path);
            path.setLength(len);
        }
    }

    class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> res = new ArrayList<>();
            StringBuffer sb = new StringBuffer();
            helper(root, res, new String());
            return res;
        }

        private void helper(TreeNode root, List<String> res, String path){
            if(root == null){
                return;
            }
            if(root.left == null && root.right == null){
                // path.append(root.val);
                path += root.val;
                res.add(new String(path));
                return;
            }

            helper(root.left, res, path + root.val + "->");
            // path.setLength(path.length() - 1);
            helper(root.right, res, path+ root.val + "->");
            // path.setLength(path.length() - 1);
        }
    }
}
