package microsoft;

import java.util.Stack;

public class addTwoNumbersII {

    class SolutionFollowUp {
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
            int carryOne = 0;
            ListNode cur = null;
            ListNode next = null;
            while(!stack1.isEmpty() || !stack2.isEmpty()){
                int val1 = stack1.isEmpty() ? 0 : stack1.pop();
                int val2 = stack2.isEmpty() ? 0 : stack2.pop();
                int sum = val1 + val2 + carryOne;
                cur = new ListNode(sum % 10);
                carryOne = sum / 10;
                cur.next = next;
                next = cur;
            }
            if(carryOne > 0){
                cur = new ListNode(carryOne);
                cur.next = next;
            }
            return cur;
        }
    }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode rl1 = reverse(l1);
            ListNode rl2 = reverse(l2);
            ListNode dummy = new ListNode(0);
            ListNode head = dummy;
            int carryOne = 0;
            while(rl1 != null || rl2 != null){
                int val1 = rl1 == null ? 0 : rl1.val;
                int val2 = rl2 == null ? 0 : rl2.val;
                int sum = val1 + val2 + carryOne;
                dummy.next = new ListNode(sum % 10);
                dummy = dummy.next;
                carryOne = sum / 10;
                rl1 = rl1 == null ? null : rl1.next;
                rl2 = rl2 == null ? null : rl2.next;
            }
            if(carryOne > 0){
                dummy.next = new ListNode(carryOne);
            }
            ListNode res = reverse(head.next);
            return res;
        }

        private ListNode reverse(ListNode l){
            ListNode head = l;
            ListNode next = null;
            while(head != null){
                ListNode tmp = head.next;
                head.next = next;
                next = head;
                head = tmp;
            }
            return next;
        }
    }
}
