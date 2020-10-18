package Bloomberg;

import java.util.Stack;

public class addTwoNumbersII {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val,ListNode next) { this.val = val; this.next = next; }
    }

    class SolutionStack {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Stack<ListNode> s1 = new Stack<>();
            Stack<ListNode> s2 = new Stack<>();
            while(l1 != null){
                s1.push(l1);
                l1 = l1.next;
            }
            while(l2 != null){
                s2.push(l2);
                l2 = l2.next;
            }
            ListNode prev = null;
            int carryone = 0;
            while(!s1.isEmpty() || !s2.isEmpty()){
                int v1 = s1.isEmpty() ? 0 : s1.pop().val;
                int v2 = s2.isEmpty() ? 0 : s2.pop().val;
                int sum = v1 + v2 + carryone;
                carryone = sum / 10;
                ListNode node  = new ListNode(sum % 10);
                node.next = prev;
                prev = node;
            }
            if(carryone == 1){
                ListNode res = new ListNode(1);
                res.next = prev;
                return res;
            }
            return prev;
        }
    }
    class SolutionReverse {

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

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode rl1 = reverse(l1);
            ListNode rl2 = reverse(l2);
            int carryone = 0;
            ListNode dummy = new ListNode(0);
            ListNode head = dummy;
            while(rl1 != null || rl2 != null){
                int v1 = rl1 == null ? 0 : rl1.val;
                int v2 = rl2 == null ? 0 : rl2.val;
                int sum = v1 + v2 + carryone;
                carryone = sum / 10;
                head.next = new ListNode(sum % 10);
                head = head.next;
                rl1 = rl1 == null ? null : rl1.next;
                rl2 = rl2 == null ? null : rl2.next;
            }
            if(carryone == 1){
                head.next = new ListNode(1);
                head = head.next;
            }
            ListNode res = reverse(dummy.next);
            return res;
        }
    }
}
