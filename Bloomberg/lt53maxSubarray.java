package Bloomberg;

public class lt53maxSubarray {

    class Solution {
        public int maxSubArray(int[] nums) {
            if(nums == null || nums.length == 0){
                return 0;
            }
            int max = Integer.MIN_VALUE;
            int prevSum = 0;
            for(int i = 0; i < nums.length; i++){
                if(prevSum < 0){
                    prevSum = nums[i];
                }else{
                    prevSum += nums[i];
                }
                max = Math.max(max, prevSum);
            }
            return max;
        }
    }
}
