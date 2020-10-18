package Bloomberg;

public class flattendd {

    class SolutionIterative{
        Node prev = null;
        /*
        idealy: flatten will return the head of a correct result
         */
        public Node flatten(Node head) {
            if(head == null){
                return head;
            }
            Node cur = head;
            while(cur != null){
                if(cur.child != null){
                    Node next = cur.next;
                    cur.child.prev = cur;
                    cur.next = flatten(cur.child);
                    cur.child = null;
                    if(next != null){
                        prev.next = next;
                        next.prev = prev;
                    }
                }
                prev = cur;
                cur = cur.next;
            }
            return head;
        }
    }
}
