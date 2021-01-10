package binarysearch;

import java.util.*;

public class bs826HighestVolumeStocks {


    /*
    Accept
    Initialization: O(N + NLogN)
    Add: O(LogN)
    TopK: O(KLogN)

    HashMap, which helps us to know given a stock, what's its current volume
    TreeMap, which maintains
        a descending order ↓ of the stock groups based on its volume.
        within the group it's ascending order ↑ based on stock name, satisfying the lexicographically requirement by the question.

     */
    class Solution1{

        class StockMarket {
            HashMap<String, Integer> map;
            TreeMap<Integer, TreeSet<String>> tmap;
            public StockMarket(String[] stocks, int[] amounts) {
                map = new HashMap<>();
                tmap = new TreeMap<>(Collections.reverseOrder());
                for(int i = 0; i < stocks.length; i++){
                    String name = stocks[i];
                    int amount = amounts[i];
                    map.put(name, amount);
                    TreeSet<String> tset = tmap.getOrDefault(amount, new TreeSet<>());
                    tset.add(name);
                    tmap.put(amount, tset);
                }
            }

            public void add(String s, int amount) {
                Integer curVol = map.getOrDefault(s, 0);
                TreeSet<String> tset = tmap.get(curVol);
                if(tset != null){
                    tset.remove(s);
                }
                curVol += amount;
                tset = tmap.getOrDefault(curVol, new TreeSet<>());
                tset.add(s);
                tmap.put(curVol, tset);
                map.put(s, curVol);
            }

/*
TreeMap的values是排序之后return的
*/
            public String[] top(int k) {
                String[] res = new String[k];
                int idx = 0;
                outer: for(TreeSet<String> tset : tmap.values()){
                    for(String s : tset){
                        res[idx++] = s;
                        if(idx == k){
                            break outer;
                        }
                    }
                }
                return res;
            }
        }
    }

    /*
    TLE: O(1) add and constructor, Nlogk top
     */
    class Solution{
        class Node{
            String name;
            int amount;
            public Node(String name, int amount){
                this.name = name;
                this.amount = amount;
            }
        }
        class StockMarket {
            HashMap<String, Node> map;
            public StockMarket(String[] stocks, int[] amounts) {
                map = new HashMap<>();
                for(int i = 0; i < stocks.length; i++){
                    String name = stocks[i];
                    int amount = amounts[i];
                    if(map.containsKey(name)){
                        Node node = map.get(name);
                        node.amount += amount;
                    }else{
                        Node node = new Node(name, amount);
                        map.put(name, node);
                    }
                }
            }

            public void add(String s, int amount) {
                if(map.containsKey(s)){
                    Node node = map.get(s);
                    node.amount += amount;
                }else{
                    Node node = new Node(s, amount);
                    map.put(s, node);
                }
            }

            public String[] top(int k) {
                PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->a.amount == b.amount ? b.name.compareTo(a.name) : a.amount - b.amount);
                for(String key : map.keySet()){
                    Node node = map.get(key);
                    pq.add(node);
                    if(pq.size() > k){
                        pq.poll();
                    }
                }
                String[] res = new String[k];
                for(int i = 0; i < k; i++){
                    Node node = pq.poll();
                    res[k - i - 1] = node.name;
                }
                return res;
            }
        }
    }

}
