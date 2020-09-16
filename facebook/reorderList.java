package facebook;

public class reorderList {

    class Solution {
        public void reorderList(ListNode head) {
            if(head == null || head.next == null)
                return;
            ListNode slow = head;
            ListNode fast = head;
            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            //1-2-3-null
            //4-3-null
            ListNode l2 = reverse(slow);
            ListNode l1 = head;
            ListNode tmp;
            while(l2.next != null){
                tmp = l1.next;
                l1.next = l2;
                l1 = tmp;

                tmp = l2.next;
                l2.next = l1;
                l2 = tmp;
            }
        }


        private ListNode reverse(ListNode head){
            ListNode cur = head;
            ListNode next = null;
            while(cur != null){
                ListNode tmp = cur.next;
                cur.next = next;
                next = cur;
                cur = tmp;
            }
            return next;
        }
    }

}
