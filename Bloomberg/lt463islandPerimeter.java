package Bloomberg;

public class lt463islandPerimeter {

    class Solution {
        /*
        for each one cell just count 4 dirs of 1s, 4 - # of surronds
        */
        int[][] dirs = {{0,1}, {-1,0}, {0, -1}, {1,0}};
        public int islandPerimeter(int[][] grid) {
            int res = 0;
            int m = grid.length;
            int n = grid[0].length;
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(grid[i][j] == 1){
                        int perimeter = 4;
                        for(int k = 0; k < 4; k++){
                            int nr = i + dirs[k][0];
                            int nc = j + dirs[k][1];
                            if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1){
                                perimeter--;
                            }
                        }
                        res += perimeter;
                    }
                }
            }
            return res;
        }
    }
}
