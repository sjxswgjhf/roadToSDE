package facebook;

import java.util.LinkedList;
import java.util.Queue;

public class serializeTree {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public class Codec {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuffer sb = new StringBuffer();
            helper(root, sb);
            return sb.toString();
        }

        private void helper(TreeNode root, StringBuffer sb){
            if(root == null){
                sb.append(".#");
                return;
            }
            sb.append(root.val+"#");
            helper(root.left, sb);
            helper(root.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] strs = data.split("#");
            Queue<String> queue = new LinkedList<>();
            for(String str : strs){
                queue.add(str);
            }
            return deshelper(queue);
        }

        private TreeNode deshelper(Queue<String> queue){
            String str = queue.poll();
            if(str.equals(".")){
                return null;
            }
            TreeNode root = new TreeNode(Integer.valueOf(str));
            root.left = deshelper(queue);
            root.right = deshelper(queue);
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
}
