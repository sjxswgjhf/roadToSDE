package Bloomberg;

public class lt209minSubarrayLen {

    class SolutionBADSELF {
        /*
        two pointer:

        2 3 1 2 4 3
        sum=2 5 6 8 => 6 7 6 => 9 7
        r=0 1 2 3 => 4 5
        l=0 => 1 2 3 4
        ans = 3 - 0 + 1 = 4 => 2 3 1 2
        ans = 4 - 1 + 1 = 4 => 3 1 2 4
        ans = 4 - 2 + 1 = 3 => 1 2 4
        ans = 5 - 3 + 1 = 3
        ans = 5 - 4 + 1 =2

        */
        public int minSubArrayLen(int s, int[] nums) {
            int l = 0, r = 0;
            int ans = nums.length + 1;
            int sum = 0;
            while(r < nums.length){
                while(r < nums.length && sum < s){
                    sum += nums[r];
                    r++;
                }
                while(l <= r && sum >= s){
                    ans = Math.min(r - l, ans);
                    sum -= nums[l];
                    l++;
                }
            }
            return ans == nums.length + 1? 0 : ans;
        }
    }

    class SolutionClean {
        /*
        two pointer
        */
        public int minSubArrayLen(int s, int[] nums) {
            int l = 0, r = 0;
            int ans = nums.length + 1;
            int sum = 0;
            while(r < nums.length){
                sum += nums[r];
                while(l <= r && sum >= s){
                    ans = Math.min(r - l + 1, ans);
                    sum -= nums[l];
                    l++;
                }
                r++;
            }
            return ans == nums.length + 1 ? 0 : ans;
        }
    }
}
