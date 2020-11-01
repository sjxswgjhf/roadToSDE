package Bloomberg;

public class lt116connectPBT {



    class Solution {
        /*
        prefect的特殊性:右边不为空的话，左边一定会有
        当前层帮下层搭建链接
        */
        public Node connect(Node root) {
            if(root == null){
                return root;
            }
            if(root.right != null){
                root.left.next = root.right;
                if(root.next != null){
                    root.right.next = root.next.left;
                }else{
                    root.right.next = null;
                }
            }
            root.left = connect(root.left);
            root.right = connect(root.right);
            return root;
        }
    }
}
