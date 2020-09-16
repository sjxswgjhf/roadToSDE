package facebook;

import java.util.LinkedList;
import java.util.Queue;

public class shortestDistance {

    /*
    从每个1开始去计算到每个0的距离，并累计当前0cell能有多少个building到达，每遇到一个1就做BFS，累计distance跟building num到每个0，
    最后找能达到所有building的最小的cell 0
     */

    class Solution {
        public int shortestDistance(int[][] grid) {
            if(grid == null || grid.length == 0){
                return 0;
            }
            int[][] dirs = {{1,0}, {0, 1}, {-1, 0}, {0, -1}};
            int m = grid.length;
            int n = grid[0].length;
            int[][] distance = new int[m][n];
            int[][] reach = new int[m][n];
            int buildNum = 0;
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(grid[i][j] == 1){
                        buildNum++;
                        Queue<int[]> queue = new LinkedList<>();
                        queue.offer(new int[]{i, j});
                        boolean[][] visited = new boolean[m][n];
                        int level = 1;
                        while(!queue.isEmpty()){
                            int size = queue.size();
                            for(int k = 0; k < size; k++){
                                int[] cur = queue.poll();
                                for(int d = 0; d < 4; d++){
                                    int nr = cur[0] + dirs[d][0];
                                    int nc = cur[1] + dirs[d][1];
                                    if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 0 && !visited[nr][nc]){
                                        visited[nr][nc] = true;
                                        distance[nr][nc] += level;
                                        reach[nr][nc]++;
                                        queue.offer(new int[]{nr, nc});
                                    }
                                }
                            }
                            level++;
                        }
                    }
                }
            }
            int res = Integer.MAX_VALUE;
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(grid[i][j] == 0 && reach[i][j] == buildNum){
                        res = Math.min(res, distance[i][j]);
                    }
                }
            }
            return res == Integer.MAX_VALUE ? -1 : res;
        }
    }

    //too slow
    class SolutionBFSWith0 {
        int res = Integer.MAX_VALUE;
        int[][] dirs = {{1,0}, {0, -1}, {-1, 0}, {0, 1}};
        public int shortestDistance(int[][] grid) {
            int buildings = 0;
            int m = grid.length;
            int n = grid[0].length;
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(grid[i][j] == 1){
                        buildings++;
                    }
                }
            }
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(grid[i][j] == 0){
                        Queue<int[]> queue = new LinkedList<>();
                        boolean[][] visited = new boolean[m][n];
                        queue.add(new int[]{i, j});
                        int count = 0;
                        int step = 0;
                        int total = 0;
                        boolean end = false;
                        while(!queue.isEmpty() && !end){
                            int size = queue.size();
                            step++;
                            for(int a = 0; a < size; a++){
                                int[] cur = queue.poll();
                                for(int k = 0; k < 4; k++){
                                    int nr = cur[0] + dirs[k][0];
                                    int nc = cur[1] + dirs[k][1];
                                    if(nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]){
                                        if(grid[nr][nc] == 0){
                                            queue.add(new int[]{nr, nc});
                                            visited[nr][nc] = true;
                                        }
                                        if(grid[nr][nc] == 1){
                                            visited[nr][nc] = true;
                                            count += 1;
                                            total += step;
                                        }
                                        if(grid[nr][nc] == 2){
                                            visited[nr][nc] = true;
                                        }
                                    }
                                }
                                if(count == buildings){
                                    res = Math.min(res, total);
                                    end = true;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            return res == Integer.MAX_VALUE ? -1 : res;
        }

    }
}
