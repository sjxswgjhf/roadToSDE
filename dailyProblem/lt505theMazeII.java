package dailyProblem;

import java.util.PriorityQueue;

public class lt505theMazeII {

    /*
    dijkstra algorithm
     */
    class Solution {
        public int shortestDistance(int[][] maze, int[] start, int[] dest) {
            int m = maze.length;
            int n = maze[0].length;
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[2] - b[2]);
            pq.add(new int[]{start[0], start[1], 0});
            boolean[][] visited = new boolean[m][n];
            int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
            while(!pq.isEmpty()){
                int[] cur = pq.poll();
                if(cur[0] == dest[0] && cur[1] == dest[1]){
                    return cur[2];
                }
                visited[cur[0]][cur[1]] = true;
                for(int i = 0 ; i < 4; i++){
                    int dirsr = dirs[i][0];
                    int dirsc = dirs[i][1];
                    int nextr = cur[0];
                    int nextc = cur[1];
                    int spaces = 0;
                    while(nextr >= 0 && nextr < m && nextc >= 0 && nextc < n && maze[nextr][nextc] == 0){
                        nextr += dirsr;
                        nextc += dirsc;
                        spaces++;
                    }
                    spaces -= 1;
                    nextr = nextr - dirsr;
                    nextc = nextc - dirsc;
                    if(!visited[nextr][nextc]){
                        pq.add(new int[]{nextr, nextc, cur[2] + spaces});
                    }
                }
            }
            return -1;
        }
    }

}
