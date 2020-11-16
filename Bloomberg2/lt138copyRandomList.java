package Bloomberg2;

import java.util.HashMap;

public class lt138copyRandomList {


// Definition for a Node.
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


    /*
    当当前node有random的时候我们就需要处理，如果这个random指向的node还没建立，我们建立新node，不然就返回建立了的
    */
    class Solution {

        public Node copyRandomList(Node head) {
            if(head == null){
                return null;
            }
            Node newhead = new Node(head.val);
            Node cur = newhead;
            //key: oldnode, val: newNode
            HashMap<Node, Node> map = new HashMap<>();
            map.put(head, newhead);
            while(head != null){
                //next也要用helper去得到，因为如果去new的话，我们再处理random 的时候会把后面的node已经建好了，所以是不对的
                cur.next = getNode(head.next, map);
                cur.random = getNode(head.random, map);
                cur = cur.next;
                head = head.next;
            }
            return newhead;
        }

        private Node getNode(Node node, HashMap<Node, Node> map ){
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
