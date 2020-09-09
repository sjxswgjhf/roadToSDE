package microsoft;


public class reverseList {

    private ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode next = null;
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = next;
            next = cur;
            cur = tmp;
        }
        return next;
    }
}
