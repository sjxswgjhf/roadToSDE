package Bloomberg2;

public class lt430flatten {


class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};


    class Solution {
        Node prev = null;
        public Node flatten(Node head) {
            if(head == null){
                return null;
            }
            Node cur = head;
            while(cur != null){
                if(cur.child != null){
                    Node next = cur.next;
                    Node childhead = flatten(cur.child);
                    cur.next = childhead;
                    childhead.prev = cur;
                    cur.child = null;
                    prev.next = next;
                    if(next != null)
                        next.prev = prev;
                }
                prev = cur;
                cur = cur.next;
            }
            return head;
        }
    }
}
