package RoadTo1K;

import java.util.LinkedList;
import java.util.Queue;

public class lt449serialize {

    public class Codec {

    /*
    preorder做不了，因为没法确定root的位置
    postorder的话，root会在最后面，然后用stack的FILO来做，最先出来的是root
    inorder的话，root在第一个，用queue来做,

    */

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuffer code = new StringBuffer();
            if(root == null){
                return "";
            }
            helper(root, code);
            return code.toString();
        }
        //2#1#x#x#3#x#x#
        private void helper(TreeNode root, StringBuffer code){
            if(root == null){
                code.append("x#");
                return;
            }
            code.append(root.val);
            code.append("#");
            helper(root.left, code);
            helper(root.right, code);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data == null || data.length() == 0){
                return null;
            }
            //2 1 x x 3 x x
            String[] codes = data.split("#");
            Queue<String> queue = new LinkedList();
            for(String code : codes){
                queue.add(code);
            }
            return buildTree(queue);
        }

        private TreeNode buildTree(Queue<String> queue){
            String str = queue.poll();
            if(str.equals("x")){
                return null;
            }
            TreeNode root = new TreeNode(Integer.valueOf(str));
            root.left = buildTree(queue);
            root.right = buildTree(queue);
            return root;
        }
    }
}
