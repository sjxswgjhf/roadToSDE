package Bloomberg;

public class lt328oddEvenList {

    class Solution {
        /*

        1 2 3 4 5 6 7
        2 1 3 5 6 4 7
        需要odd跟even指针，odd指向第一个，even指向第二个，开始循环的时候，odd指向even后面，even.next需要设置成
        even.next.next，因为需要断开中间的odd node，然后even跟odd同时往后移动，循环结束后，odd tail跟evenhead链接
        */
        public ListNode oddEvenList(ListNode head) {
            if(head == null){
                return null;
            }
            ListNode odd = head;
            ListNode even = head.next;
            //保留head用来最后链接odd跟even
            ListNode evenHead = even;
            while(even != null && even.next != null){
                odd.next = even.next;
                //这里需要断开odd的node，这样最后行程的even list是只有even 的listnode，不然会有odd listnode
                even.next = even.next.next;
                odd = odd.next;
                even = even.next;
            }
            odd.next = evenHead;
            return head;
        }
    }
}
