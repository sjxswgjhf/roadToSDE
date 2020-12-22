package BloombergOnsite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class lt451frequencySort {

    class SolutionBuckerSort {
        public String frequencySort(String s) {
            if(s == null || s.length() == 0){
                return new String();
            }
            HashMap<Character, Integer> map = new HashMap<>();
            int max = 0;
            for(char c : s.toCharArray()){
                map.put(c, map.getOrDefault(c, 0) + 1);
                max = Math.max(max, map.get(c));
            }
            List<List<Character>> list = new ArrayList<>();
            for(int i = 0 ; i <= max; i++){
                list.add(new ArrayList<>());
            }
            StringBuffer sb = new StringBuffer();
            for(Character c : map.keySet()){
                list.get(map.get(c)).add(c);
            }
            for(int i = max; i >= 0; i--){
                List<Character> cs = list.get(i);
                for(Character c : cs){
                    for(int j = 0; j < i; j++){
                        sb.append(c);
                    }
                }
            }
            return sb.toString();
        }
    }

    class SolutionSort {

        class Node{
            char c;
            int freq;
            public Node(char c, int f){
                this.c = c;
                this.freq = f;
            }
        }

        public String frequencySort(String s) {
            PriorityQueue<Node> pq = new PriorityQueue<>((a, b)->(a.freq == b.freq ? (a.c)-(b.c) : b.freq - a.freq));
            HashMap<Character, Integer> map = new HashMap<>();
            for(char c : s.toCharArray()){
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            for(Character c : map.keySet()){
                Node node = new Node(c, map.get(c));
                pq.add(node);
            }
            StringBuffer res = new StringBuffer();
            while(!pq.isEmpty()){
                Node node = pq.poll();
                int freq = node.freq;
                for(int i = 0; i < freq; i++){
                    res.append(node.c);
                }
            }
            return res.toString();
        }
    }

}
