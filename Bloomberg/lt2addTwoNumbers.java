package Bloomberg;

public class lt2addTwoNumbers {

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int carryone = 0;
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;
            while(l1 != null || l2 != null){
                int v1 = l1 == null ? 0 : l1.val;
                int v2 = l2 == null ? 0 : l2.val;
                int sum = v1 + v2 + carryone;
                carryone = sum / 10;
                ListNode node = new ListNode(sum % 10);
                cur.next = node;
                cur = cur.next;
                l1 = l1 == null ? null : l1.next;
                l2 = l2 == null ? null : l2.next;
            }
            if(carryone != 0){
                cur.next = new ListNode(carryone);
            }
            return dummy.next;
        }
    }
}
