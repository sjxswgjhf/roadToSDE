package RoadTo1K;

public class lt237deleteNode {


    /*
    这题就不该教叫deletenode，离谱,直接修改val，替换成后面的，最后把node设为null
     */
    class Solution {
        public void deleteNode(ListNode node) {
            ListNode cur = node;
            ListNode next = null;
            while(cur.next.next != null){
                next = cur.next;
                int val = cur.val;
                cur.val = next.val;
                next.val = val;
                cur = cur.next;
            }
            cur.val = cur.next.val;
            cur.next = null;
        }
    }
}
