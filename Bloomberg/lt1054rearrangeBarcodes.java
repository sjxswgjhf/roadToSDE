package Bloomberg;

import java.util.HashMap;
import java.util.PriorityQueue;

public class lt1054rearrangeBarcodes {

    class Solution {

        class Node{
            int val;
            int freq;
            public Node(int v, int f){
                this.val = v;
                this.freq = f;
            }
        }

        public int[] rearrangeBarcodes(int[] barcodes) {

            HashMap<Integer, Integer> map = new HashMap<>();
            for(int barcode : barcodes){
                map.put(barcode, map.getOrDefault(barcode, 0) + 1);
            }
            PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.freq == b.freq ? a.val - b.val : b.freq - a.freq);
            for(int key : map.keySet()){
                int val = map.get(key);
                Node node = new Node(key, val);
                pq.add(node);
            }

            int[] res = new int[barcodes.length];
            for(int i = 0; i < barcodes.length; i+=2){
                Node node1 = pq.poll();
                Node node2 = pq.isEmpty() ? null : pq.poll();
                res[i] = node1.val;
                if(i + 1 < barcodes.length){
                    res[i + 1] = node2.val;
                }
                node1.freq--;
                if(node2 != null)
                    node2.freq--;
                if(node1.freq > 0)
                    pq.add(node1);
                if(node2 != null && node2.freq > 0){
                    pq.add(node2);
                }
            }
            return res;
        }
    }
}
