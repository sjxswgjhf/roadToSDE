package dailyProblem;

import java.util.LinkedList;
import java.util.Queue;

public class lt785isBipartite {

    class Solution {
        public boolean isBipartite(int[][] graph) {
            int n = graph.length;
            int[] color = new int[n];
            Queue<Integer> queue = new LinkedList<>();

            for(int k = 0; k < n; k++){
                if(color[k] == 0){
                    color[k] = 1;
                    queue.add(k);
                    int nextColor = 1;
                    while(!queue.isEmpty()){
                        int size = queue.size();
                        nextColor *= -1;
                        for(int i = 0; i < size; i++){
                            int cur = queue.poll();
                            int[] adj = graph[cur];
                            for(int j = 0 ; j < adj.length; j++){
                                if(color[adj[j]] == 0){
                                    color[adj[j]] = nextColor;
                                    queue.add(adj[j]);
                                }else{
                                    if(color[adj[j]] != nextColor){
                                        return false;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return true;
        }
    }
}
