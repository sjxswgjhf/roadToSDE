package RoadTo1K;

public class lt1351countNegatives {

    class Solution {
        public int countNegatives(int[][] grid) {
            int count = 0;
            int m = grid.length;
            int n = grid[0].length;
            for(int i = 0; i < m; i++){
                if(grid[i][0] < 0){
                    count += n;
                    continue;
                }
                for(int j = n - 1; j >= 0; j--){
                    if(grid[i][j] < 0){
                        count++;
                    }else{
                        break;
                    }
                }
            }
            return count;
        }
    }
}
