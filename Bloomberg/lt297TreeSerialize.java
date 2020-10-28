package Bloomberg;

import java.util.LinkedList;
import java.util.Queue;

public class lt297TreeSerialize {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuffer sb = new StringBuffer();
            helper(root, sb);
            System.out.println(sb.toString());
            return sb.toString();
        }

        private void helper(TreeNode root, StringBuffer sb){
            if(root == null){
                sb.append(".#");
                return;
            }
            sb.append(root.val);
            sb.append("#");
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
            TreeNode head = helper(queue);
            return head;
        }

        private TreeNode helper(Queue<String> queue){
            if(queue.isEmpty()){
                return null;
            }
            String str = queue.poll();
            if(str.equals(".")){
                return null;
            }
            int val = Integer.valueOf(str);
            TreeNode root = new TreeNode(val);
            root.left = helper(queue);
            root.right = helper(queue);
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
}
