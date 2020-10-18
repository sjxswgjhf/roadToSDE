package IMC;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class minKnightMoves {

    class Solution {

        int[][] dirs = new int[][] {{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};

        public int minKnightMoves(int x, int y) {
            x = Math.abs(x);
            y = Math.abs(y);
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0, 0});
            HashSet<String> visited = new HashSet<>();
            visited.add("0#0");
            int res = 0;
            while(!queue.isEmpty()){
                int size = queue.size();
                while(size-- > 0){
                    int[] cur = queue.poll();
                    int curX = cur[0];
                    int curY = cur[1];
                    if(curX == x && curY == y){
                        return res;
                    }
                    for(int[] dir : dirs){
                        int nextX = curX + dir[0];
                        int nextY = curY + dir[1];
                        String pattern = nextX+"#"+nextY;
                        if(!visited.contains(pattern) && nextX >= -1 && nextY >= -1){
                            queue.add(new int[] {nextX, nextY});
                            visited.add(nextX + "#" + nextY);
                        }
                    }
                }
                res++;
            }
            return -1;
        }
    }
}
