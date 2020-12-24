package BloombergOnsite;

import java.util.HashMap;

public class lt138copyRandomList {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    class Solution {
        /*
        这题我们一开始只要在main里面新建新的head，其他的我们不需要在main里面创建，因为我们find next的时候会创建这些node
        用个map记录旧的node跟我们创建的的node，如果遇到一个旧的node，我们直接可以给新建的node，不然的话我们就建一个node，
        然后建立pair，放入map
        */
        public Node copyRandomList(Node head) {
            if(head == null){
                return null;
            }
            Node newHead = new Node(head.val);
            Node cur = newHead;
            HashMap<Node, Node> map = new HashMap<>();
            map.put(head, newHead);
            while(head != null){
                cur.next = getNode(head.next, map);
                cur.random = getNode(head.random, map);
                cur = cur.next;
                head = head.next;
            }
            return newHead;
        }

        private Node getNode(Node node, HashMap<Node, Node> map){
            if(node == null){
                return null;
            }else{
                if(map.containsKey(node)){
                    return map.get(node);
                }else{
                    Node newNode = new Node(node.val);
                    map.put(node, newNode);
                    return newNode;
                }
            }
        }
    }
}
