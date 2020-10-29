package Bloomberg;

public class lt152maxProduct {

    class Solution {
        /*
        这题需要知道前面的最大最小值是多少，然后当前的最大最小值是根据前面的最大最小值来得，如果当前为负数，就跟之前的最小值相乘，
        跟本身取max就是当前max，当前min就是跟之前最大值相乘就是最小值，
        反之当前为正，那么跟先前最大相乘或自身为最大，跟先前最小相乘或自身为最小。
        然后max取决于本身还是maxVal。
        这题可以降维成O(1)space,因为我们只需要知道前一个的最大最小值就可以了，两个int val就可以
        */
        public int maxProduct(int[] nums) {

            int max = nums[0];
            int[] minVal = new int[nums.length];
            int[] maxVal = new int[nums.length];
            minVal[0] = nums[0];
            maxVal[0] = nums[0];

            for(int i = 1; i < nums.length; i++){

                if(nums[i] < 0){
                    maxVal[i] = Math.max(minVal[i - 1 ] * nums[i], nums[i]);
                    minVal[i] = Math.min(maxVal[i - 1] * nums[i], nums[i]);
                }else{
                    maxVal[i] = Math.max(maxVal[i - 1] * nums[i], nums[i]);
                    minVal[i] = Math.min(minVal[i - 1] * nums[i], nums[i]);
                }
                max = Math.max(max, maxVal[i]);
            }
            return max;
        }
    }
}
