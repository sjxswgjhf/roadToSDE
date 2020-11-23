package RoadTo1K;

import java.util.PriorityQueue;

public class lt767reorganizedString {

    class Solution {
        /*
          贪心做法，count freq，然后排序
          然后构建res，注意当前pq的顶部的node是不是之前塞到sb最后 的那个node，是的话要换下一个node，如果没有下一个node了，就是invalid情况，无法构成解
          不然就是poll下一个node出来操作，同时塞回上面的node
        */
        class Node{
            char c;
            int freq;
            public Node(char c, int freq){
                this.c = c;
                this.freq = freq;
            }
        }
        public String reorganizeString(String s) {
            int[] counts = new int[26];
            for(char c : s.toCharArray()){
                counts[c - 'a']++;
            }
            PriorityQueue<Node> pq = new PriorityQueue<>((a, b)->b.freq-a.freq);
            for(int i = 0; i < 26; i++){
                if(counts[i] > 0){
                    Node node = new Node((char)('a' + i), counts[i]);
                    pq.add(node);
                }
            }
            StringBuffer sb = new StringBuffer();
            while(!pq.isEmpty()){
                if(pq.size() == 1 && pq.peek().freq > 1){
                    return "";
                }else{
                    Node node;
                    if(sb.length() > 0 && pq.peek().c == sb.charAt(sb.length() - 1)){
                        Node tmp = pq.poll();
                        if(pq.isEmpty()){
                            return "";
                        }
                        node = pq.poll();
                        pq.add(tmp);
                    }else{
                        node = pq.poll();
                    }
                    sb.append(node.c);
                    node.freq--;
                    if(node.freq > 0)
                        pq.add(node);
                }
            }
            return sb.toString();
        }
    }
}
