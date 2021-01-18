package dailyProblem;

import java.util.*;

public class lt787findCheapestPrice {

    class Solution {
        class Node{
            int dst;
            int price;
            int stops;
            public Node(int t, int p, int s){
                this.dst = t;
                this.price = p;
                this.stops = s;
            }
        }
        public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
            HashMap<Integer, List<Node>> map = new HashMap<>();
            for(int[] flight : flights){
                int f = flight[0];
                int t = flight[1];
                int p = flight[2];
                Node node = new Node(t, p, 0);
                List<Node> list = map.getOrDefault(f, new ArrayList<>());
                list.add(node);
                map.put(f, list);
            }
            int[] prices = new int[n];
            Arrays.fill(prices, Integer.MAX_VALUE);
            prices[src] = 0;
            PriorityQueue<Node> pq = new PriorityQueue<>((a,b)-> a.price == b.price ? a.dst - b.dst : a.price - b.price);
            pq.add(new Node(src, 0, 0));
            while(!pq.isEmpty()){
                Node node = pq.poll();
                if(node.dst == dst){
                    return node.price;
                }
                if(node.stops <= K){
                    List<Node> adjs = map.getOrDefault(node.dst, new ArrayList<>());
                    for(Node adj : adjs){
                        //不能这样写，pq里面的别的node会收到影响
                        // adj.price = adj.price + node.price;
                        // adj.stops = node.stops + 1;
                        pq.add(new Node(adj.dst, adj.price + node.price, node.stops + 1));
                    }
                }
            }
            return -1;
        }
    }
}
