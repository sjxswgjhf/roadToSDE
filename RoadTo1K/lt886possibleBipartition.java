package RoadTo1K;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class lt886possibleBipartition {


    class Solution {
        /*
        coloring problem:
        把当前一个人先color了，然后把所有dislike的人color成另一个颜色，如果当中有color过的并且颜色颜色不一样的就是false了

        分组需要建立graph，用到第一个hashmap
        然后需要一个map去记录当前所有color过的node跟对应的颜色，
        如果是就bipartition的话我们用0跟1表示颜色，用^1来操作，这样0^1 = 1, 1 ^ 1 = 0
        */
        public boolean possibleBipartition(int N, int[][] dislikes) {
            HashMap<Integer, List<Integer>> map = new HashMap<>();
            for(int[] dislike : dislikes){
                List<Integer> l1 = map.getOrDefault(dislike[0], new ArrayList<>());
                List<Integer> l2 = map.getOrDefault(dislike[1], new ArrayList<>());
                l1.add(dislike[1]);
                l2.add(dislike[0]);
                map.put(dislike[0], l1);
                map.put(dislike[1], l2);
            }
            HashMap<Integer, Integer> colored = new HashMap<>();
            int color = 1;
            for(int i = 1; i <= N; i++){
                //没被color过，并且能color所有neigh
                if(!colored.containsKey(i) && !dfs(i, 0, colored, map)){
                    return false;
                }
            }
            return true;
        }

        private boolean dfs(int cur, int color, HashMap<Integer, Integer> colored, HashMap<Integer, List<Integer>> map ){
            if(colored.containsKey(cur)){
                return colored.get(cur) == color;
            }
            colored.put(cur, color);
            for(int neigh : map.getOrDefault(cur, new ArrayList<>())){
                if(!dfs(neigh, color^1, colored, map)){
                    return false;
                }
            }
            return true;
        }
    }
}
