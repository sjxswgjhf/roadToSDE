package dailyProblem;

import java.util.HashMap;

public class lt1248numberOfSubarrays {

    /*
    sliding window
     */
    class SolutionSliding {
        public int numberOfSubarrays(int[] nums, int k) {
            int l = 0, r = 0, len = nums.length;
            int count = 0, oddCount = 0, evenCount = 0;

            while(r < len){

                while(r < len && oddCount < k){
                    if(nums[r++] % 2 != 0)  ++oddCount;
                }

                evenCount = 1;
                while(r < len && nums[r] % 2 == 0){
                    ++evenCount;
                    ++r;
                }
                while(l < len && oddCount == k){
                    count += evenCount;
                    if(nums[l++] % 2 != 0) --oddCount;
                }
            }

            return count;
        }
    }

    /*
    prefix sum
     */
    class Solution {
        public int numberOfSubarrays(int[] nums, int k) {
            int n = nums.length;
            int[] prefix = new int[n + 1];
            for(int i = 1; i <= n; i++){
                prefix[i] = (nums[i - 1] % 2) + prefix[i - 1];
            }
            int count = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i <= n; i++){
                count += map.getOrDefault(prefix[i] - k, 0);
                map.put(prefix[i], map.getOrDefault(prefix[i], 0) + 1);
            }
            return count;
        }
    }

}
