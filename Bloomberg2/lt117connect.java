package Bloomberg2;

public class lt117connect {

    class Solution {
        Node leftMost;
        Node prev;
        public Node connect(Node root) {
            if(root == null){
                return root;
            }
            leftMost = root;
            prev = null;
            while(leftMost != null){
                Node cur = leftMost;
                leftMost = null;
                prev = null;
                while(cur != null){
                    processChild(cur.left);
                    processChild(cur.right);
                    cur = cur.next;
                }
            }
            return root;
        }

        private void processChild(Node node){
            if(node == null){
                return;
            }else{
                if(leftMost == null){
                    leftMost = node;
                }
                if(prev == null){
                    prev = node;
                }else{
                    prev.next = node;
                    prev = node;
                }
            }
        }
    }
}
