package Bloomberg;

public class mergeTwoLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(c1 != null || c2 != null){
            int v1 = c1 == null ? Integer.MAX_VALUE : c1.val;
            int v2 = c2 == null ? Integer.MAX_VALUE : c2.val;
            if(v1 <= v2){
                cur.next = new ListNode(v1);
                c1 = c1.next;
            }
            else{
                cur.next = new ListNode(v2);
                c2 = c2.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
