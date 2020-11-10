package Bloomberg;

public class lt21mergeTwoLists {

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0);

            ListNode cur = dummy;
            while(l1 != null || l2 != null){
                int val1 = l1 == null ? Integer.MAX_VALUE : l1.val;
                int val2 = l2 == null ? Integer.MAX_VALUE : l2.val;
                if(val1 <= val2){
                    cur.next = new ListNode(val1);
                    cur = cur.next;
                    l1 = l1.next;
                }
                else{
                    cur.next = new ListNode(val2);
                    cur = cur.next;
                    l2 = l2.next;
                }
            }
            return dummy.next;
        }
    }
}
