package Bloomberg;

import java.util.HashMap;
import java.util.PriorityQueue;

public class lt451frequencySort {

    class Solution {

        class Node{
            char c;
            int freq;
            public Node(char c, int f){
                this.c = c;
                this.freq = f;
            }
        }

        public String frequencySort(String s) {
            if(s == null || s.length() == 0){
                return new String();
            }
            HashMap<Character, Integer> map = new HashMap<>();
            for(char c : s.toCharArray()){
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            // String res = "";
            StringBuffer sb = new StringBuffer();
            PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);
            for(Character c : map.keySet()){
                Node node = new Node(c, map.get(c));
                pq.add(node);
            }
            while(!pq.isEmpty()){
                Node node = pq.poll();
                int freq = node.freq;
                while(freq-- > 0){
                    // res+=node.c;
                    sb.append(node.c);
                }
            }
            return sb.toString();
        }
    }
}
