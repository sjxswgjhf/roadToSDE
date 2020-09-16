package facebook;

public class addTwoNumbers {

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
            int carryone = 0;
            ListNode dummy = new ListNode(0);
            ListNode head = dummy;
            while(l1 != null || l2 != null){
                int val1 = l1 == null ? 0 : l1.val;
                int val2 = l2 == null ? 0 : l2.val;
                int sum = val1 + val2 + carryone;
                carryone = sum > 9 ? 1 : 0;
                dummy.next = new ListNode(sum % 10);
                dummy = dummy.next;
                l1 = l1 == null ? null : l1.next;
                l2 = l2 == null ? null : l2.next;
            }
            if(carryone != 0){
                dummy.next = new ListNode(carryone);
            }
            return head.next;
        }
    }

}
