package microsoft;

import java.util.Arrays;

public class lengthOfLIS {

    class Solution {
        public int lengthOfLIS(int[] nums) {
            if(nums == null || nums.length == 0){
                return 0;
            }
            int n = nums.length;
            int[] incrlen = new int[n];
            Arrays.fill(incrlen, 1);
            int ans = 1;
            for(int i = 1; i < n; i++){
                for(int j = i - 1; j >= 0; j--){
                    if(nums[j] < nums[i]){
                        incrlen[i] = Math.max(incrlen[i], incrlen[j]+1);
                    }
                    ans = Math.max(ans, incrlen[i]);
                }
            }
            return ans;
        }
    }

}
