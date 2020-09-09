package microsoft;

public class searchMatrix {

    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
                return false;
            }
            int start = 0, end = matrix.length - 1;
            int mid = 0;
            int n = matrix[0].length - 1;
            while(start <= end){
                mid = start + (end - start) / 2;
                if(target >= matrix[mid][0] && target <= matrix[mid][n]){
                    for(int i = 0; i <= n; i++){
                        if(matrix[mid][i] == target){
                            return true;
                        }
                    }
                    return false;
                }
                else if(target > matrix[mid][0]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
            return false;
        }
    }
}
