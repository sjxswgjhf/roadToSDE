package RoadTo1K;

public class lt566matrixReshape {

    class Solution {
        public int[][] matrixReshape(int[][] nums, int r, int c) {
            int m = nums.length;
            int n = nums[0].length;
            if(n * m != r * c){
                return nums;
            }
            int[][] res = new int[r][c];
            int idxr = 0;
            int idxc = 0;
            for(int i = 0; i < r; i++){
                for(int j = 0; j < c; j++){
                    res[i][j] = nums[idxr][idxc];
                    idxc++;
                    if(idxc == n){
                        idxc = 0;
                        idxr++;
                    }
                }
            }
            return res;
        }
    }
}
