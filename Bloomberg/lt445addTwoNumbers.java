package Bloomberg;

import java.util.Stack;

public class lt445addTwoNumbers {

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Stack<Integer> stack1 = new Stack<>();
            Stack<Integer> stack2 = new Stack<>();
            while(l1 != null){
                stack1.push(l1.val);
                l1 = l1.next;
            }
            while(l2 != null){
                stack2.push(l2.val);
                l2 = l2.next;
            }
            int carryone = 0;
            Stack<Integer> res = new Stack<>();
            while(!stack1.isEmpty() || !stack2.isEmpty()){
                int v1 = stack1.isEmpty() ? 0 : stack1.pop();
                int v2 = stack2.isEmpty() ? 0 : stack2.pop();
                int sum = v1 + v2 + carryone;
                carryone = sum / 10;
                res.push(sum % 10);
            }
            if(carryone == 1){
                res.push(1);
            }
            ListNode head = new ListNode(0);
            ListNode dummy = head;
            while(!res.isEmpty()){
                head.next = new ListNode(res.pop());
                head = head.next;
            }
            return dummy.next;
        }
    }
}
