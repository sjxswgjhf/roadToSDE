package Bloomberg;

import java.util.HashMap;
import java.util.PriorityQueue;

public class lt347topKFrequent {

    class Solution {
        class Node{
            int val;
            int freq;
            public Node(int val, int freq){
                this.val = val;
                this.freq = freq;
            }
        }
        public int[] topKFrequent(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int num : nums){
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            PriorityQueue<Node> pq = new PriorityQueue<>((a, b)->a.freq - b.freq);
            for(int key : map.keySet()){
                Node node = new Node(key, map.get(key));
                pq.add(node);
                if(pq.size() > k){
                    pq.poll();
                }
            }
            int[] res = new int[pq.size()];
            for(int i = 0; i < res.length; i++){
                res[i] = pq.poll().val;
            }
            return res;
        }
    }
}
