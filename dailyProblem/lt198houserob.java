package dailyProblem;

public class lt198houserob {

    class Solution {
        public int rob(int[] nums) {
            if(nums == null || nums.length == 0){
                return 0;
            }
            int n = nums.length;
            int[] rob = new int[n + 1];
            rob[0] = 0;
            rob[1] = nums[0];
            for(int i = 2; i <= n; i++){
                rob[i] = Math.max(rob[i - 1], rob[i - 2] + nums[i - 1]);
            }
            return rob[n];
        }
    }
}
