package microsoft;

public class getIntersectionNode {

   public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tmpA = headA;
        int lenA = countLen(tmpA);
        ListNode tmpB = headB;
        int lenB = countLen(tmpB);
        while(lenA != 0 && lenB != 0){
            if(lenA > lenB){
                headA = headA.next;
                lenA--;
            }
            else if(lenA == lenB){
                if(headA == headB){
                    return headA;
                }else{
                    headA = headA.next;
                    headB = headB.next;
                    lenA--;
                    lenB--;
                }
            }
            else{
                headB = headB.next;
                lenB--;
            }
        }
        return null;
    }

    private int countLen(ListNode l){
        int len = 0;
        while(l != null){
            l = l.next;
            len++;
        }
        return len;
    }
}


