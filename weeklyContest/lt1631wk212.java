package weeklyContest;

import java.util.Arrays;
import java.util.PriorityQueue;

public class lt1631wk212 {
    /*
    weekly contest 212 problem 3: unsolved

    这题用dijkstra来做。

    把每个cell都设为无穷远，然后从start为0开始走，在走的过程中，我们计算四个方向需要达到的effort，然后如果当前effort比那个cell已存在
    的小的话，我们就更新，并把那个cell放入priorityqueue中，然后知道我们遇到了end的那个cell，我们返回答案
    为什么是对的？考试的时候卡在了怎么避免重复计算。
    其实当我们用priorityqueue去做bfs的时候，我们会发现，是根据effort来处理的。那么如果当前的cell是最小的情况了，不论周围的cell是不是会
    再考虑当前cell，因为不是最优的了，所以不会加入到pq里面，也就把重复计算避免掉了，而且，如果我们有一个路径已经到了end了。但是这个被加入
    到pq的时候是会排到后面的。因为effort可能比较大，而我们在loop pq的时候，会优先处理小的effort，即如果有另一条路径也能到end，而且总effort
    会比先到的那条小的话，我们会计算到这条路径，而且这个cell的情况会加到pq里面，并会被优先于先前那条路径的cell先遇到。返回这条路径的结果
     */

    class Solution {

        class Cell{
            int x;
            int y;
            int effort;
            public Cell(int x, int y, int effort){
                this.x = x;
                this.y = y;
                this.effort = effort;
            }
        }

        int[][] dirs = {{1,0}, {0, -1}, {-1, 0}, {0, 1}};
        public int minimumEffortPath(int[][] heights) {
            int m = heights.length;
            int n = heights[0].length;
            int[][] dp = new int[m][n];
            for(int i = 0; i < m; i++){
                Arrays.fill(dp[i], Integer.MAX_VALUE);
            }
            PriorityQueue<Cell> pq = new PriorityQueue<>((a, b)->a.effort - b.effort);
            Cell start = new Cell(0, 0, 0);
            pq.add(start);
            while(!pq.isEmpty()){
                Cell cur = pq.poll();
                // System.out.println(cur.x + " "+ cur.y + " " + cur.effort);
                //reach bottom right
                if(cur.x == m - 1 && cur.y == n - 1){
                    return cur.effort;
                }
                //four directions
                for(int i = 0; i < 4; i++){
                    int nr = dirs[i][0] + cur.x;
                    int nc = cur.y + dirs[i][1];
                    if(nr >= 0 && nr < m && nc >= 0 && nc < n){
                        //查看之前到下一格的effort大，还是当前
                        int effort = Math.max(cur.effort, Math.abs(heights[nr][nc] - heights[cur.x][cur.y]));
                        if(dp[nr][nc] > effort){
                            dp[nr][nc] = effort;
                            Cell cell = new Cell(nr, nc, effort);
                            pq.add(cell);
                        }
                    }
                }
            }
            return 0;
        }
    }
}
