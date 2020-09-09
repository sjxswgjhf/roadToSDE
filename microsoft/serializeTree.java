package microsoft;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class serializeTree {


    public class CodecPreorder {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuffer sb = new StringBuffer();
            serializehelper(root, sb);
            return sb.toString();
        }

        private void serializehelper(TreeNode node, StringBuffer sb){
            if(node == null){
                sb.append(".#");
                return;
            }
            sb.append(node.val+"#");
            serializehelper(node.left, sb);
            serializehelper(node.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data == null || data.length() == 0){
                return null;
            }
            Queue<String> strs = new LinkedList<>();
            strs.addAll(Arrays.asList(data.split("#")));
            return deserializehelper(strs);
        }

        private TreeNode deserializehelper(Queue<String> queue){
            String s = queue.poll();
            if(s.equals(".")){
                return null;
            }else{
                TreeNode root = new TreeNode(Integer.valueOf(s));
                root.left = deserializehelper(queue);
                root.right = deserializehelper(queue);
                return root;
            }
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));



    public class CodecPostOrder {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuffer sb = new StringBuffer();
            serializehelper(root, sb);
            return sb.toString();
        }

        private void serializehelper(TreeNode root, StringBuffer sb){
            if(root == null){
                sb.append(".#");
                return;
            }
            serializehelper(root.right, sb);
            serializehelper(root.left, sb);
            sb.append(root.val+"#");
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            Stack<String> stack = new Stack<>();
            stack.addAll(Arrays.asList(data.split("#")));
            return deserializehelper(stack);
        }

        private TreeNode deserializehelper(Stack<String> stack){
            String s = stack.pop();
            if(s.equals(".")){
                return null;
            }
            TreeNode root = new TreeNode(Integer.valueOf(s));
            root.left = deserializehelper(stack);
            root.right = deserializehelper(stack);
            return root;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
}
