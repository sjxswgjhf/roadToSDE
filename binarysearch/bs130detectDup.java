package binarysearch;

public class bs130detectDup {

    /*
    利用idx跟num一起做xor，unique的都会变成0，然后dp的那一个会单独保留,nice!
     */
    class SolutionO1Space {
        public int solve(int[] nums) {
            int res = 0;
            for(int i = 0; i < nums.length; i++){
                res ^= i ^ nums[i];
            }
            return res;
        }
    }

    class SolutionLogN {
        public int solve(int[] nums) {
            int n = nums.length;
            int sum = n * (n - 1) / 2;
            for(int num : nums){
                sum -= num;
            }
            return Math.abs(sum);
        }
    }
}
