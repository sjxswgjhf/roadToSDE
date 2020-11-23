package RoadTo1K;

public class lt725splitListToParts {
    /*
    这题需要先计算长度，然后可以求得每个bucket的size跟remainder，
    然后需要一个prev的node去记录前一个node，这样到每个bucket结束的时候需要break。set next to null，
    然后当前bucket的size是取决于rem是不是还有剩下，剩下的话就把是size+1，不然就是size了
     */
    class Solution {
        public ListNode[] splitListToParts(ListNode root, int k) {
            int len = findLen(root);
            int size = len / k;
            int rem = len % k;
            ListNode[] res = new ListNode[k];
            ListNode cur = root;
            ListNode prev = null;
            for(int i = 0; i < k; i++){
                res[i] = cur;
                int tmpsize = rem-- > 0 ? size + 1 : size;
                //prev用来断开链接
                for(int j = 0; j < tmpsize; j++){
                    prev = cur;
                    cur = cur.next;
                }
                if(prev != null){
                    prev.next = null;
                }
            }
            return res;
        }

        private int findLen(ListNode root){
            int len = 0;
            while(root != null){
                len++;
                root = root.next;
            }
            return len;
        }
    }
}
