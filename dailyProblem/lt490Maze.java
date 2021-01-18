package dailyProblem;

import java.util.LinkedList;
import java.util.Queue;

public class lt490Maze {

    class Solution {
        public boolean hasPath(int[][] maze, int[] start, int[] dest) {
            int m = maze.length;
            int n = maze[0].length;
            Queue<int[]> queue = new LinkedList<>();
            queue.add(start);
            boolean[][] visited = new boolean[m][n];
            int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0 ; i < size; i++){
                    int[] cur = queue.poll();
                    if(cur[0] == dest[0] && cur[1] == dest[1]){
                        return true;
                    }
                    visited[cur[0]][cur[1]] = true;
                    for(int j = 0; j < 4; j++){
                        int dirsr = dirs[j][0];
                        int dirsc = dirs[j][1];
                        int nextr = cur[0];
                        int nextc = cur[1];
                        while(nextr >= 0 && nextr < m && nextc >= 0 && nextc < n && maze[nextr][nextc] == 0){
                            nextr += dirsr;
                            nextc += dirsc;
                        }
                        nextr = nextr - dirsr;
                        nextc = nextc - dirsc;
                        // System.out.println(nextr + " " + nextc);
                        if(nextr == cur[0] && nextc == cur[1]){
                            continue;
                        }
                        if(!visited[nextr][nextc]){
                            queue.add(new int[]{nextr , nextc});
                        }
                    }
                }
            }
            return false;
        }
    }
}
