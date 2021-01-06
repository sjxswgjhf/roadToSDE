package binarysearch;

public class bs440linkedlistIntersection {

    class Solution {
        public LLNode solve(LLNode l0, LLNode l1) {
            LLNode dummy = new LLNode(0);
            LLNode cur = dummy;
            while(l0 != null && l1 != null){
                if(l0.val == l1.val){
                    cur.next = new LLNode(l0.val);
                    cur = cur.next;
                    l0 = l0.next;
                    l1 = l1.next;
                }
                else if(l0.val > l1.val){
                    l1 = l1.next;
                }
                else{
                    l0 = l0.next;
                }
            }
            return dummy.next;
        }
    }
}
