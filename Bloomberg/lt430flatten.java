package Bloomberg;

public class lt430flatten {

    /*
    这题的思路是recursion，每当cur.child不是null的时候，就要去flattern，因为flattern返回的是head，我们直接把cur.next变成返回的node
    但是我们cur.next要跟child的尾巴接上啊，怎么处理呢，我们需要一个prev node去记录child最后一个node，这样我们处理了cur的child，就可以用
    prev跟next去链接
     */
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
                    cur.child.prev = cur;
                    cur.next = flatten(cur.child);
                    cur.child = null;
                    if(next != null) {
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
