package RoadTo1K;

import java.util.HashMap;

public class lt1722minimumHammingDistance {


    class Solution {

        /*
        所有的swap是形成了通路，然后我们按照source，把所有的source用map来存放，同一个root下就+1，
        然后走target，如果target里面找的root不存在map中或已经用完了，就是dif，res++，存在的话就把count--，
        */
        int[] ranks;
        int[] parents;
        public int minimumHammingDistance(int[] source, int[] target, int[][] swaps) {
            int n = source.length;
            ranks = new int[n];
            parents = new int[n];
            for(int i = 0; i < n; i++){
                parents[i] = i;
            }

            //union all the swaps
            for(int[] swap : swaps){
                int x = swap[0];
                int y = swap[1];
                int px = find(x);
                int py = find(y);
                if(px != py){
                    if(ranks[px] < ranks[py]){
                        parents[px] = py;
                        ranks[py] += 1;
                    }
                    else{
                        parents[py] = px;
                        ranks[px] += 1;
                    }
                }
            }
            HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
            for(int i = 0; i < n; i++){
                int s = source[i];
                int root = find(i);     //union的是idx
                // HashMap<Integer, Integer> store = map.getOrDefault(root, new HashMap<>());
                map.putIfAbsent(root, new HashMap<>());
                HashMap<Integer, Integer> store = map.get(root);
                store.put(s, store.getOrDefault(s, 0) + 1);
            }
            int res = 0;
            for(int i = 0; i < n; i++){
                int t = target[i];
                int root = find(i);
                HashMap<Integer, Integer> store = map.get(root);
                if(store.getOrDefault(t, 0) == 0){
                    res++;
                }else{
                    store.put(t, store.get(t) - 1);
                }
            }
            return res;
        }

        private int find(int x){
            if(parents[x] != x){
                parents[x] = find(parents[x]);
            }
            return parents[x];
        }

    }
}
