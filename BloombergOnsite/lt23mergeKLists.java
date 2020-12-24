package BloombergOnsite;

import java.util.PriorityQueue;

public class lt23mergeKLists {

    class SolutionDivideConquer {
        public ListNode mergeKLists(ListNode[] lists) {
            return partition(lists, 0, lists.length - 1);
        }

        private ListNode partition(ListNode[] lists, int l, int r){
            if(l > r){
                return null;
            }
            else if(l == r){
                return lists[l];
            }
            else{
                int q = (l + r) / 2;
                ListNode left = partition(lists, l, q);
                ListNode right = partition(lists, q + 1, r);
                return merge(left, right);
            }
        }

        private ListNode merge(ListNode l1, ListNode l2){
            if(l1 == null && l2 == null){
                return null;
            }
            else if(l1 == null){
                return l2;
            }
            else if(l2 == null){
                return l1;
            }
            else{
                if(l1.val < l2.val){
                    l1.next = merge(l1.next, l2);
                    return l1;
                }else{
                    l2.next = merge(l1, l2.next);
                    return l2;
                }
            }
        }
    }

    class SolutionPQ {
        public ListNode mergeKLists(ListNode[] lists) {
            if(lists == null || lists.length == 0){
                return null;
            }
            PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b)->a.val-b.val);
            for(ListNode node : lists){
                if(node != null)
                    pq.add(node);
            }
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;
            while(!pq.isEmpty()){
                ListNode node = pq.poll();
                cur.next = new ListNode(node.val);
                node = node.next;
                if(node != null){
                    pq.add(node);
                }
                cur = cur.next;
            }
            return dummy.next;
        }
    }
}
