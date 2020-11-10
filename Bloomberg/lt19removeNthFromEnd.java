package Bloomberg;

public class lt19removeNthFromEnd {

    class Solution {
        /*
        两个指针，前指针先走到n的位置，前后指针再同时走，这样就保持了n的距离

        0 1 2 3 4 5 null
        f     f f f  f
        s s s s

        */
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode first = dummy;
            ListNode second = dummy;
            for(int i = 0; i <= n ;i++){
                first = first.next;
            }
            while(first != null){
                second = second.next;
                first = first.next;
            }
            second.next = second.next.next;
            return dummy.next;
        }
    }
}
