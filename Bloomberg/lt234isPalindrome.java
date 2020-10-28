package Bloomberg;

public class lt234isPalindrome {

    class Solution {
        /*
        Could you do it in O(n) time and O(1) space?

        1 - > 2 -> 2 -> 1 -> null
        sf
              s    f
                   s           f

        1 -> 2 -> 3 -> 2 -> 1
        sf
             s    f
                  s         f

        1 -> 2
        1 -> 2

        1 -> 2
        1 -> 2 -> 3

        find midpoint
        reverse right half
        compare
        */
        public boolean isPalindrome(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode rhead = reverse(slow);
            while(head != null && rhead != null){
                if(head.val != rhead.val){
                    return false;
                }
                head = head.next;
                rhead = rhead.next;
            }
            return true;
        }

        /*
        1- > 2 ->3
        prev = null -> 1 -> 2 -> 3
        cur = 1 -> 2 -> 3 -> null
        next = 2 -> 3 -> null
        null <- 1 <- 2 <- 3
        */
        private ListNode reverse(ListNode head){
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
}
