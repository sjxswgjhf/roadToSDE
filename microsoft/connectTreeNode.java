package microsoft;

public class connectTreeNode {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public Node connect(Node root){
        if(root == null || root.left == null){
            return root;
        }
        //perfect tree左边有的话，右边肯定有
        root.left.next = root.right;
        //把left subtree的right child 跟 right subtree的left child连起来
        if(root.next  != null){
            root.right.next = root.next.left;
        }else{
            root.next = null;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}
