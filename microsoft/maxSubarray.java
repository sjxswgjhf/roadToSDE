package microsoft;

public class maxSubarray {

    class Solution {
        public int maxSubArray(int[] nums) {
            int n = nums.length;
            long max = nums[0];
            long[] sums = new long[n];
            sums[0] = nums[0];
            for(int i = 1; i < n; i++){
                if(sums[i-1] > 0){
                    sums[i] = sums[i - 1] + nums[i];
                }else{
                    sums[i] = nums[i];
                }
                max = Math.max(sums[i], max);
            }
            return (int)max;
        }
    }

}
