package binarysearch;

import java.util.HashMap;

public class bs385subarraySumToK {

    /*
    hashmap存了所有的sum的情况跟freq，然后看当前idx的时候，之前有没有一个sum-k的key存在，有的话就累计，
    edge case是sum是0的时候为1,这个hashmap的思想就是prefix sum的思想.
    按solution里面的说法是如果两个idx的sum是一样的，那么他们中间的 sum就是0，
    那么也就是说sum[i]-sum[j]=k的话，那么sum[i+1]~sum[j]就是k
     */

    class Solution {
        public int solve(int[] nums, int target) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int count = 0;
            int sum = 0;
            map.put(0, 1);
            for(int i = 0; i < nums.length; i++){
                sum += nums[i];
                if(map.containsKey(sum - target)){
                    count += map.get(sum - target);
                }
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            return count;
        }
    }

    class SolutionNN {
        public int solve(int[] nums, int target) {
            int[] prefixSum = new int[nums.length + 1];
            for(int i = 1; i <= nums.length; i++){
                prefixSum[i] = prefixSum[i - 1] + nums[i-1];
            }
            int count = 0;
            for(int i = 0; i <= nums.length; i++){
                for(int j = 0; j < i; j++){
                    if(prefixSum[i] - prefixSum[j] == target){
                        count++;
                    }
                }
            }
            return count;
        }
    }
}
