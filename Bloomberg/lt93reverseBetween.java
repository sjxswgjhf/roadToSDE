package Bloomberg;

public class lt93reverseBetween {


/*

prev = null cur = 1
m = 2 , n = 4
prev = 1 cur = 2 m = 1 n = 3
tail = cur = 2
prev = 2 cur = 3 n = 2
prev = 3 cur = 4 n = 1
题目不难，就是edge case要注意，比较讨厌
*/
    class Solution {
        public ListNode reverseBetween(ListNode head, int m, int n) {
            if(m == n){
                return head;
            }
            ListNode prev = null, cur = head;
            while(m > 1){
                prev = cur;
                cur = cur.next;
                m--;
                n--;
            }
            ListNode front = prev;
            ListNode tail = cur;
            prev = null;
            while(n >= 1){
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
                n--;
            }
            if(front != null){
                front.next = prev;
            }else{
                head = prev;
            }
            tail.next = cur;
            return head;
        }
    }
}
