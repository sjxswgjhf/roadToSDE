package Bloomberg;

public class lt160getIntersectionNode {

    public class Solution {
        /*
        solution:
            a + c + b
            b + c + a
        个人做法是计算两个list的长度，先走一个长度，直到跟短的一样长然后一起走。 O(n+m+max(m,n)) O(1)
        */
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if(headA == null || headB == null){
                return null;
            }
            ListNode curA = headA;
            ListNode curB = headB;
            while(curA != curB){
                curA = curA == null ? headB : curA.next;
                curB = curB == null ? headA : curB.next;
            }
            return curA;
        }
    }
}
