package Bloomberg;

public class lt61rotateRight {

    class Solution {
        /*
        1->2->3->4->5->NULL, k = 2
        */
        ListNode tail;    //5
        public ListNode rotateRight(ListNode head, int k) {
            if(k == 0){
                return head;
            }
            if(head == null){
                return head;
            }
            int len = findLen(head);
            if(k % len == 0){
                return head;
            }
            k = k % len;
            ListNode cur = head;
            ListNode prev = null;
            while(len > k){
                len--;  // 4 3 2
                prev = cur;
                cur = cur.next; // 1->2 -> 3
            }
            //prev = 3, cur= 4, tail = 5
            tail.next = head;
            prev.next = null;
            return cur;
        }

        private int findLen(ListNode head){
            int len = 0;
            ListNode prev = null;
            while(head != null){
                len++;
                prev = head;
                head = head.next;
            }
            this.tail = prev;
            return len;
        }
    }

}
