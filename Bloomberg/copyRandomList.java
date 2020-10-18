package Bloomberg;

import java.util.HashMap;

public class copyRandomList {

    class Node{
        int val;
        Node next ,random;
        public Node(int v, Node next, Node random){
            this.random = random;
            this.next = next;
            this.val = v;
        }
    }

    HashMap<Node, Node> map = new HashMap<>();
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        if(map.containsKey(head)){
            return map.get(head);
        }else{
            Node node = new Node(head.val, null, null);
            node.next = copyRandomList(head.next);
            node.random = copyRandomList(head.random);
            return node;
        }
    }
}
