package Bloomberg2;

import java.util.Stack;

public class lt445addTwoNumbersII {

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Stack<Integer> s1 = new Stack<>();
            Stack<Integer> s2 = new Stack<>();
            while(l1 != null){
                s1.push(l1.val);
                l1 = l1.next;
            }
            while(l2 != null){
                s2.push(l2.val);
                l2 = l2.next;
            }
            int carryone = 0;
            ListNode next = null;
            ListNode cur = null;
            while(!s1.isEmpty() || !s2.isEmpty()){
                int v1 = s1.isEmpty() ? 0 : s1.pop();
                int v2 = s2.isEmpty() ? 0 : s2.pop();
                int sum = v1 + v2 + carryone;
                carryone = sum / 10;
                cur = new ListNode(sum % 10);
                cur.next = next;
                next = cur;
            }
            if(carryone > 0){
                cur = new ListNode(carryone);
                cur.next = next;
            }
            return cur;
        }
    }
}
