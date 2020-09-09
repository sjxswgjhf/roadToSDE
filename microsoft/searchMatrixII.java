package microsoft;

public class searchMatrixII {

    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
                return false;
            }
            int m = matrix.length;
            int n = matrix[0].length;
            for(int i = 0; i < m; i++){
                if(target >= matrix[i][0] && target <= matrix[i][n-1]){
                    if(check(matrix[i],target)){
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean check(int[] nums, int target){
            int start = 0;
            int end = nums.length - 1;
            while(start <= end){
                int mid = start + (end - start) / 2;
                if(nums[mid] == target){
                    return true;
                }
                else if(nums[mid] < target){
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
            return false;
        }
    }
}
