package BloombergOnsite;

public class lt21mergeTwoLists {

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;
            while(l1 != null || l2 != null){
                int v1 = l1 == null ? Integer.MAX_VALUE : l1.val;
                int v2 = l2 == null ? Integer.MAX_VALUE : l2.val;
                if(v1 <= v2){
                    cur.next = new ListNode(v1);
                    l1 = l1 == null ? null : l1.next;
                }
                else{
                    cur.next = new ListNode(v2);
                    l2 = l2 == null ? null : l2.next;
                }
                cur = cur.next;
            }
            return dummy.next;
        }
    }
}
