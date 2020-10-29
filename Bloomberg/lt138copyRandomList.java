package Bloomberg;

import java.util.HashMap;

public class lt138copyRandomList {

    /*
    每次遇到新的node都要建立对应的新node，然后复制对应的next跟random，那我们next跟random可能已经建立了，我们需要一个hashmap去拿建立好的
    我们还需要一个临时变量记录新的head最后返回
     */

    class Node{
        int val;
        Node random;
        Node next;
        public Node(int v, Node r, Node n){
            this.val = v;
            this.random = r;
            this.next = n;
        }
    }
    class solution{

        HashMap<Node, Node> map;

        private Node copyNode(Node cur){
            if(cur == null){
                return null;
            }
            else if(map.containsKey(cur)){
                return map.get(cur);
            }
            else{
                Node node = new Node(cur.val, null, null);
                map.put(cur, node);
                return node;
            }
        }

        public Node copyRandomList(Node head){
            if(head == null){
                return null;
            }
            map = new HashMap<>();
            Node  newHead = new Node(head.val, null, null);
            map.put(head, newHead);
            Node tmp = newHead;
            while(head != null){
                newHead.next = copyNode(head.next);
                newHead.random = copyNode(head.random);
                newHead = newHead.next;
                head = head.next;
            }
            return tmp;
        }


    }

}
