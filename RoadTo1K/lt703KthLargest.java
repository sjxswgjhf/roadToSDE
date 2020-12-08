package RoadTo1K;

import java.util.PriorityQueue;

public class lt703KthLargest {
    class KthLargest {

        PriorityQueue<Integer> pq;
        int m;
        public KthLargest(int k, int[] nums) {
            pq = new PriorityQueue<>();
            m = k;
            for(int num : nums){
                pq.add(num);
                if(pq.size() > k){
                    pq.poll();
                }
            }
        }

        public int add(int val) {
            if(pq.size() < m){
                pq.add(val);
            }else{
                if(pq.peek() < val){
                    pq.poll();
                    pq.add(val);
                }
            }
            return pq.peek();
        }
    }
}
