package microsoft;

import java.util.PriorityQueue;

public class mergeKLists {
    class SolutionDivideConquer {
        public ListNode mergeKLists(ListNode[] lists) {
            return partion(lists, 0, lists.length -1);
        }

        public ListNode partion(ListNode[] lists, int s, int e){
            if(s == e){
                return lists[e];
            }
            if(s < e){
                int q = (s + e) / 2;
                ListNode l1 = partion(lists, s, q);
                ListNode l2 = partion(lists, q + 1, e);
                return merge(l1, l2);
            }else{
                return null;
            }
        }

        public ListNode merge(ListNode l1, ListNode l2){
            if(l1 == null){
                return l2;
            }
            if(l2 == null){
                return l1;
            }
            if(l1.val < l2.val){
                l1.next = merge(l1.next, l2);
                return l1;
            }
            else{
                l2.next = merge(l1, l2.next);
                return l2;
            }
        }
    }


    class SolutionPQ {
        public ListNode mergeKLists(ListNode[] lists) {
            if(lists == null || lists.length == 0){
                return null;
            }
            PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b)->a.val > b.val ? 1 : -1);
            for(ListNode list : lists){
                if(list != null)
                    pq.offer(list);
            }
            ListNode dummy = new ListNode(0);
            ListNode head = dummy;
            while(!pq.isEmpty()){
                ListNode cur = pq.poll();
                dummy.next = new ListNode(cur.val);
                dummy = dummy.next;
                if(cur.next != null){
                    pq.offer(cur.next);
                }
            }
            return head.next;
        }
    }
}
