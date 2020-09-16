package facebook;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class isBipartite {

    class SolutionBFS {
        public boolean isBipartite(int[][] graph) {
            int n = graph.length;
            int[] colors = new int[n];
            for(int i = 0; i< n; i++){
                if(colors[i] != 0){
                    continue;
                }else{
                    Queue<Integer> queue = new LinkedList<>();
                    queue.add(i);
                    colors[i] = 1;
                    while(!queue.isEmpty()){
                        int cur = queue.poll();
                        for(int nei : graph[cur]){
                            if(colors[nei] == 0){
                                colors[nei] = -colors[cur];
                                queue.offer(nei);
                            }else{
                                if(colors[nei] == colors[cur]){
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
            return true;
        }
    }


    class SolutionDFS {
        public boolean isBipartite(int[][] graph) {
            int n = graph.length;
            int[] colors = new int[n];
            for(int i = 0 ; i < n; i++){
                if(colors[i] == 0){
                    if(!validColor(graph, colors, 1, i)){
                        return false;
                    }
                }
            }
            return true;
        }

        private boolean validColor(int[][] graph, int[] colors, int color, int idx){
            if(colors[idx] != 0){
                return colors[idx] == color;
            }
            colors[idx] = color;
            for(int next : graph[idx]){
                if(!validColor(graph, colors, -color, next)){
                    return false;
                }
            }
            return true;
        }
    }

    class Solution {
        public boolean isBipartite(int[][] graph) {
            int n = graph.length;
            int[] color = new int[n];

            for (int start = 0; start < n; ++start) {
                if (color[start] == 0) {
                    Stack<Integer> stack = new Stack();
                    stack.push(start);
                    color[start] = 1;

                    while (!stack.empty()) {
                        Integer node = stack.pop();
                        for (int nei: graph[node]) {
                            if (color[nei] == 0) {
                                stack.push(nei);
                                color[nei] = -color[node];
                            } else if (color[nei] == color[node]) {
                                return false;
                            }
                        }
                    }
                }
            }

            return true;
        }
    }
}
