package RoadTo1K;

import java.util.Arrays;

public class lt1099twoSumLessThanK {

    class Solution {
        public int twoSumLessThanK(int[] nums, int k) {
            int n = nums.length;
            int max = -1;
            Arrays.sort(nums);
            int l = 0;
            int r = n - 1;
            while(l < r){
                // int sum = nums[l] + nums[r];
                if(nums[l] + nums[r] >= k){
                    r--;
                }
                else{
                    max = Math.max(max, nums[l] + nums[r]);
                    l++;
                }
            }
            return max;
        }
    }
}
