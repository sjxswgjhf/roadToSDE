package BloombergOnsite;

public class lt206reverseList {

    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode cur = head;
            while(cur != null){
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            return prev;
        }
    }

    class SolutionRecursion {
        public ListNode reverseList(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }
            ListNode p = reverseList(head.next);    //这里返回的是5，不是2，所以不能用p.next = head,
            head.next.next = head;
            head.next = null;
            return p;
        }
    }
}
