package facebook;

import java.util.HashMap;

public class copyRandomList {

    class Node{
        int val;
        Node next, random;
        public Node(int val){
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public Node(int val, Node next, Node random){
            this.val = val;
            this.next = next;
            this.random = random;
        }
    }

    class SolutionLoop {
        HashMap<Node, Node> visited = new HashMap<>();

        private Node getcloneNode(Node node){
            if(node == null){
                return null;
            }
            if(visited.containsKey(node)){
                return visited.get(node);
            }else{
                Node n = new Node(node.val, null, null);
                visited.put(node, n);
                return n;
            }
        }

        public Node copyRandomList(Node head) {
            Node cur = new Node(head.val);
            Node old = head;
            visited.put(old, cur);
            while(old != null){
                cur.next = getcloneNode(old.next);
                cur.random = getcloneNode(old.random);
                cur = cur.next;
                old = old.next;
            }
            return visited.get(head);
        }
    }


    class SolutionRecursion {
        HashMap<Node, Node> visited = new HashMap<>();
        public Node copyRandomList(Node head) {
            if(head == null){
                return null;
            }
            if(visited.containsKey(head)){
                return visited.get(head);
            }
            Node cur = new Node(head.val);
            visited.put(head, cur);
            cur.next = copyRandomList(head.next);
            cur.random = copyRandomList(head.random);
            return cur;
        }
    }
}
