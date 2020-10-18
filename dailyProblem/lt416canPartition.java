package dailyProblem;

public class lt416canPartition {

    class Solution {
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for(int num : nums){
                sum += num;
            }
            if(sum % 2 == 1){
                return false;
            }

            boolean[] dp = new boolean[sum + 1];
            dp[0] = true;
        /*
        对于当前数字来说，加上这个数字，能勾成的所有sum有哪些。
        */
            for(int i = 0; i < nums.length; i++){
                for(int j = sum / 2; j >= 0; j--){
                    if(dp[j]){
                        dp[j + nums[i]] = true;
                    }
                }
            }
            return dp[sum / 2];

        }
    }

    class SolutionTLE {
        // DFS TLE
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for(int num : nums){
                sum += num;
            }
            if(sum % 2 != 0){
                return false;
            }
            boolean[] used = new boolean[nums.length];
            return helper(nums, sum / 2, used);
        }

        private boolean helper(int[] nums, int target, boolean[] used){
            if(target == 0){
                return true;
            }
            for(int i = 0; i < nums.length; i++){
                if(target >= nums[i] && !used[i]){
                    used[i] = true;
                    if(helper(nums, target - nums[i], used)){
                        return true;
                    }
                    used[i] = false;
                }
            }
            return false;
        }


    }
}
