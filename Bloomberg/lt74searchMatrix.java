package Bloomberg;

public class lt74searchMatrix {


    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
                return false;
            }
            int m = matrix.length;
            int n = matrix[0].length;
            for(int i = 0; i < m; i++){
                if(target <= matrix[i][n - 1] && target >= matrix[i][0]){
                    return bs(matrix[i], target);
                }
            }
            return false;
        }

        private boolean bs(int[] nums, int target){
            int l = 0;
            int r = nums.length - 1;
            while(l <= r){      //这里小于等于是因为当只有一个，或者最中间的时候
                int mid = (l + r) / 2;
                if(nums[mid] == target){
                    return true;
                }else{
                    if(nums[mid] < target){
                        l = mid + 1;
                    }
                    else{
                        r = mid - 1;
                    }
                }
            }
            return false;
        }
    }
}
