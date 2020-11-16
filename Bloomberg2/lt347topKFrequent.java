package Bloomberg2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class lt347topKFrequent {

    class Solution {
    /*
    Bucket Sort
    */

        public int[] topKFrequent(int[] nums, int k) {
            if(nums == null || nums.length == 0){
                return new int[0];
            }
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int num : nums){
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            List<Integer>[] bucket = new List[nums.length + 1];
            for(int key: map.keySet()){
                int freq = map.get(key);
                if(bucket[freq] == null){
                    bucket[freq] = new ArrayList<>();
                }
                bucket[freq].add(key);
            }
            int[] res = new int[k];
            int idx = 0;
            outer: for(int i = nums.length; i >= 0; i--){
                List<Integer> list = bucket[i];
                if(list != null){
                    for(int n : list){
                        res[idx++] = n;
                        if(idx == k){
                            break outer;
                        }
                    }
                }
            }
            return res;
        }
    }


    class SolutionNK {
    /*
    NlogK
    */
        class Node{
            int val;
            int freq;
            public Node(int val, int freq){
                this.val = val;
                this.freq = freq;
            }
        }

        public int[] topKFrequent(int[] nums, int k) {
            if(nums == null || nums.length == 0){
                return new int[0];
            }
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int num : nums){
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            PriorityQueue<Node> pq = new PriorityQueue<>((a, b)->a.freq-b.freq);
            for(int key : map.keySet()){
                Node node = new Node(key, map.get(key));
                pq.add(node);
                if(pq.size() > k){
                    pq.poll();
                }
            }
            int[] res = new int[pq.size()];
            int idx = pq.size() - 1;
            while(!pq.isEmpty()){
                Node node = pq.poll();
                res[idx--] = node.val;
            }
            return res;
        }
    }
}
