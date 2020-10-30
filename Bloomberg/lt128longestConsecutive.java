package Bloomberg;

import java.util.Arrays;
import java.util.HashMap;

public class lt128longestConsecutive {

    class SolutionFollowUp {
        /*
        HashMap:
        key: val
        val: len

        0,3,7,2,5,8,4,6,0,1
        查看左右是否存在，以及长度，如果存在的话，加上左右长度，跟自身，为新的长度，同时要更新左右两端的长度

        */
        public int longestConsecutive(int[] nums) {
            if(nums == null || nums.length == 0){
                return 0;
            }
            int n = nums.length;
            HashMap<Integer, Integer> map = new HashMap<>();
            int max = 0;
            for(int i = 0; i < n; i++){
                if(!map.containsKey(nums[i])){
                    int left = map.getOrDefault(nums[i] - 1, 0);
                    int right = map.getOrDefault(nums[i] + 1, 0);
                    int len = 1 + left + right;
                    if(left != 0){
                        map.put(nums[i] - left, len);
                    }
                    if(right != 0){
                        map.put(nums[i] + right, len);
                    }
                    map.put(nums[i], len);
                }
                max = Math.max(map.get(nums[i]), max);
            }
            return max;
        }
    }

    /*
    solution: nlog(n)
     */
    class Solution {
        public int longestConsecutive(int[] nums) {
            if(nums == null || nums.length == 0){
                return 0;
            }
            Arrays.sort(nums);
            int n = nums.length;
            int[] dp = new int[n];
            dp[0] = 1;
            int max = 1;
            for(int i = 1; i < n; i++){
                if(nums[i] - nums[i - 1] == 1){
                    dp[i] = dp[i - 1] + 1;
                }else if(nums[i] == nums[i - 1]){
                    dp[i] = dp[i - 1];
                }else{
                    dp[i] = 1;
                }
                max = Math.max(dp[i], max);
            }
            return max;
        }
    }
}
