package facebook;

public class mergeTwoLists {

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0);
            ListNode head = dummy;
            while(l1 != null || l2 != null){
                int val1 = l1 == null ? Integer.MAX_VALUE : l1.val;
                int val2 = l2 == null ? Integer.MAX_VALUE : l2.val;
                if(val1 < val2){
                    dummy.next = new ListNode(val1);
                    l1 = l1 == null ? null : l1.next;
                }else{
                    dummy.next = new ListNode(val2);
                    l2 = l2 == null ? null : l2.next;
                }
                dummy = dummy.next;
            }
            return head.next;
        }
    }

}
