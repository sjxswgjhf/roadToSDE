package binarysearch;

public class bs6specialProductList {

    class Solution {
        public int[] solve(int[] nums) {
            long[] left = new long[nums.length];
            long[] right = new long[nums.length];
            int n = nums.length;
            left[0] = 1;
            right[n-1]=1;
            for(int i = 1; i < n; i++){
                left[i] = left[i - 1] * nums[i - 1];
            }
            for(int i = n - 2; i >= 0; i--){
                right[i] = right[i + 1] * nums[i + 1];
            }

            int[] res = new int[n];
            for(int i = 0; i < n; i++){
                res[i] = (int)(left[i]) * (int)(right[i]);
            }
            return res;
        }
    }
}
