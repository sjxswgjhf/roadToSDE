package BloombergOnsite;

public class lt430flatten {

    /*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

    class Solution2ND {
        Node prev = null;
        public Node flatten(Node head) {
            if(head == null){
                return null;
            }
            Node cur = head;
            while(cur != null){
                if(cur.child != null){
                    Node next = cur.next;
                    Node child = flatten(cur.child);
                    cur.next = child;
                    child.prev = cur;
                    cur.child = null;
                    prev.next = next;
                    if(next != null){
                        next.prev = prev;
                    }
                }
                prev = cur;
                cur = cur.next;
            }
            return head;
        }
    }

    // Definition for a Node.
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };

    class Solution {
        Node prev;
        public Node flatten(Node head) {
            if(head == null){
                return null;
            }
            Node cur = head;
            while(cur != null){
                if(cur.child != null){
                    Node next = cur.next;
                    //先拿到了child flattern返回之后的head
                    Node childnode = flatten(cur.child);
                    //然后把childhead跟cur连起来
                    cur.next = childnode;
                    childnode.prev = cur;
                    //把cur的child设为null
                    cur.child = null;
                    //然后把child最后的那个node的next设为当前cur的next
                    prev.next = next;
                    //如果当前cur的next不是null，再把next的前面设为child最后那个node，即prev
                    if(next != null){
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
