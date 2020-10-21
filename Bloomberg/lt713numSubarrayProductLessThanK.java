package Bloomberg;

public class lt713numSubarrayProductLessThanK {
    class Solution {
        /*
        10 5 2 6 7 k = 100
        l = 0, r = 2 len = 3 => 3 * 4 / 2 = 6
        # of subarray = 1 + 2 + 3 = 6
        l = 0, r = 5 len = 6 => 6 * 7 / 2 = 21
        # of subarray = 1 + 2 + 3 + 4 + 5 + 6 = 21
        */
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            if(k <= 1){
                return 0;
            }
            int l = 0;
            int res = 0;
            int product = 1;
            for(int r = 0; r < nums.length; r++){
                product *= nums[r];
                while(l <= r && product >= k){
                    product /= nums[l++];
                }
                //核心
                res += r - l + 1;
            }
            return res;
        }
    }
}
