package Bloomberg;

public class addTwoNumber {


     // Definition for singly-linked list.
    private class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

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
                cur.next = new ListNode(sum % 10);
                l1 = l1 == null ? null : l1.next;
                l2 = l2 == null ? null : l2.next;
                cur = cur.next;
            }
            if(carryone == 1){
                cur.next = new ListNode(carryone);
            }
            return dummy.next;
        }
    }
}
