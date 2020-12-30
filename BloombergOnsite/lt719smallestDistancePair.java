package BloombergOnsite;

public class lt719smallestDistancePair {

    class Solution {
        /*
        BucketSort
        */
        public int smallestDistancePair(int[] nums, int k) {
            int max = 0;
            for(int i : nums){
                max = Math.max(max, i);
            }
            int[] buckets = new int[max + 1];
            int n = nums.length;
            for(int i = 0 ; i < n; i++){
                for(int j = i + 1 ; j < n; j++){
                    int dif = Math.abs(nums[i] - nums[j]);
                    buckets[dif]++;
                }
            }
            int ans = -1;
            for(int i = 0; i < max + 1; i++){
                int curFreq = buckets[i];
                if(curFreq >= k){
                    ans = i;
                    break;
                }else{
                    k -= curFreq;
                }
            }
            return ans;
        }
    }
}
