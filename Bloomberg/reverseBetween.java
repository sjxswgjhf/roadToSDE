package Bloomberg;

public class reverseBetween {
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
    class ListNode{
        int val;
        ListNode next;

    }
    class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            if(head == null){
                return null;
            }
            ListNode front = head;
            ListNode prev = null;
            while(m > 1){
                prev = front;
                front = front.next;
                m--;
                n--;
            }
            ListNode cur = front;
            ListNode next = null;
            while(n > 0){
                ListNode tmp = cur.next;
                cur.next = next;
                next = cur;
                cur = tmp;
                n--;
            }
            if(prev != null){
                prev.next = next;
            }else{
                head = next;
            }
            front.next = cur;
            return head;
        }
    }
}
