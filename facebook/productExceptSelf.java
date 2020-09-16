package facebook;

public class productExceptSelf {

    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int left = 1;
            int right = 1;
            int[] res = new int[n];
            for(int i = 0; i < n; i++){
                if(i == 0){
                    res[i] = 1;
                }else{
                    left = left * nums[i-1];
                    res[i] = left;
                }
            }
            for(int i = n - 2; i >= 0; i--){
                right = right * nums[i + 1];
                res[i] *= right;
            }
            return res;
        }
    }

    class SolutionNSpace {
        public int[] productExceptSelf(int[] nums) {
            int n = nums.length;
            int[] left = new int[n];
            int[] right = new int[n];
            left[0] = 1;
            for(int i = 1; i < n; i++){
                left[i] = left[i -1] * nums[i - 1];
            }
            right[n-1] = 1;
            for(int i = n -2; i >=0; i--){
                right[i] = right[i + 1] * nums[i + 1];
            }
            int[] res = new int[nums.length];
            for(int i = 0; i < nums.length; i++){
                if(i == 0){
                    res[i] = right[i];
                }
                else if(i == nums.length - 1){
                    res[i] = left[i];
                }else{
                    res[i] = right[i]*left[i];
                }
            }
            return res;
        }
    }
}
