package microsoft;

public class mergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while(l1 != null && l2 != null){
            if(l1.val > l2.val){
                dummy.next = new ListNode(l2.val);
                l2 = l2.next;
            }else{
                dummy.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            dummy = dummy.next;
        }
        if(l1 != null){
            dummy.next = l1;
        }
        if(l2 != null){
            dummy.next = l2;
        }
        return head.next;
    }
}
