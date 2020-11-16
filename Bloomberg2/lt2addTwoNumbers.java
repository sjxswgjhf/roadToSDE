package Bloomberg2;

public class lt2addTwoNumbers {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;
            int carryone = 0;
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
            if(carryone > 0){
                ListNode node = new ListNode(carryone);
                cur.next = node;
            }
            return dummy.next;
        }
    }
}
