package microsoft;

import java.util.LinkedList;
import java.util.Queue;

public class connectII {
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


    //prev: the prev node
    //cur: leftmost node of the processing level
    //leftmost: the leftmost node of each level
    Node prev, leftmost;

    private void processChild(Node child){
        if(child != null){
            if(this.prev != null){
                this.prev.next = child;
            }else{
                this.leftmost = child;
            }
            this.prev = child;
        }
    }
    public Node connect(Node root){
        if(root == null){
            return root;
        }
        this.leftmost = root;
        Node cur = leftmost;
        while(this.leftmost != null){
            //every level start, prev should be reset to null
            this.prev = null;
            //cur is the leftmost of the current level
            cur = this.leftmost;
            //reset leftmost for each level
            this.leftmost = null;
            //process the current level and build the leftmost for next level
            while(cur != null){
                this.processChild(cur.left);
                this.processChild(cur.right);
                cur = cur.next;
            }
        }
        return root;
    }

    public Node connectQueue(Node root){
        if(root == null){
            return null;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size; i++){
                Node node = q.poll();
                if(i < size - 1){
                    node.next = q.peek();
                }
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }
        }
        return root;
    }
}
