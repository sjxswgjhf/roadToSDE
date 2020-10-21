package Bloomberg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class lt693topKFrequent {

    class Solution {
        class Node{
            String str;
            int freq;
            public Node(String s, int f){
                str = s;
                freq = f;
            }
        }
        public List<String> topKFrequent(String[] words, int k) {
            List<String> res = new ArrayList<>();
            if(words == null || words.length == 0){
                return res;
            }
            HashMap<String, Integer> map = new HashMap<>();
            PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.freq == b.freq ? b.str.compareTo(a.str) : a.freq - b.freq);
            for(String word : words){
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
            for(String key : map.keySet()){
                Node node = new Node(key, map.get(key));
                pq.add(node);
                if(pq.size() > k){
                    pq.poll();
                }
            }
            while(!pq.isEmpty()){
                res.add(0, pq.poll().str);
            }
            return res;
        }
    }
}
