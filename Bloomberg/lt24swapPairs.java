package Bloomberg;

public class lt24swapPairs {

    class Solution {
        public ListNode swapPairs(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode prev = dummy;
            ListNode cur = head;
            ListNode next = head.next;
            while(next != null){
                prev.next = next;
                ListNode nnext = next.next;
                cur.next = nnext;
                next.next = cur;
                prev = cur;
                cur = nnext;
                if(cur != null){
                    next = cur.next;
                }
                else{
                    next = null;
                }
            }
            return dummy.next;
        }
    }
}
