package RoadTo1K;

public class lt25reverseKGroup {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        /*
        1 2 3 4 5
        newHead:记录reverse之后的head，并且只会记录一次，以后都不变
        ktail:记录之前reverse之后的tail
        cur:当前的指针

        先判断当前指针剩下的够不够k，
        够的话，我们就要reverse这段k，当前指针的位置是3，
        我们reverse(head)，reverse会返回新的head即prev，然后判断是不是第一次reverse，即newhead是不是null，是的话设置newhead，不是的话不改变newhead
        再接下来看ktail是不是null，是的话表示我们第一次reverse，之前没有tail要连接，不是的话把ktail.next设置为reverse完的head，即1-2变成3-4变成4-3，但是2-1的1要跟4链接
        再接下来我们更新ktail成之前的head，因为head还是原来的head，现在要变成tail
        然后head更新成cur，这时cur是下一轮开始时候的head了，
        如果最后不够k了，我们要记得把之前的ktail跟当前的head连起来，因为我们再while中没完成链接，
        最后返回的时候看下newhead是不是null，可能遇到一整个链表不够k的情况
        */
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode newHead = null;
            ListNode ktail = null;
            ListNode cur = head;
            while(cur != null){
                int count = 0;
                cur = head;
                while(count < k && cur != null){
                    cur = cur.next;
                    count++;
                }
                if(count == k){
                    ListNode revHead = reverse(head, k);
                    if(newHead == null){
                        newHead = revHead;
                    }
                    if(ktail != null){
                        ktail.next = revHead;
                    }
                    ktail = head;
                    head = cur;
                }
            }
            if(ktail != null){
                ktail.next = head;
            }
            return newHead == null ? head : newHead;
        }

        private ListNode reverse(ListNode head, int k){
            ListNode prev = null;
            ListNode cur = head;
            int count = 0;
            while(count < k){
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
                count++;
            }
            return prev;
        }
    }


    class SolutionRecursion {
        /*
        1 -> 2 -> 3 -> 4 -> 5
        Recursion: 先看length是不是足够，是的话就reverse,reverse返回的是新的head，而之前的head要连给剩下的reversekgroup返回的head
        */
        public ListNode reverseKGroup(ListNode head, int k) {
            if(head == null){
                return null;
            }
            int len = 0;
            ListNode tmp = head;
            while(len < k && tmp != null){
                len++;
                tmp = tmp.next;
            }
            if(len == k){
                ListNode newHead = reverse(head, k);
                head.next = reverseKGroup(tmp, k);
                return newHead;
            }
            return head;
        }

        private ListNode reverse(ListNode head, int k ){
            ListNode prev = null;
            ListNode cur = head;
            while(k > 0){
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
                k--;
            }
            return prev;
        }
    }
}
