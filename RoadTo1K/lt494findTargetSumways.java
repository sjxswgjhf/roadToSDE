package RoadTo1K;

import java.util.HashMap;

public class lt494findTargetSumways {

    class Solution {
        /*
        dp[n] = 3
        dp[i] = dp[i-1] +/- nums[i]
        dp[i-1] = dp[i-2] +/- nums[i]
        dp[0] = 1, -1
        dp[2] = 2, -2, 0
        dp[3] = ...
        所以当前的所有可能取决于前面那个的所有组合，我们可以用个data structure去存，因为size不固定，所以要用hashmap去存前面所达到的
        所有的值跟对应的freq，然后我们下一次就能更快的计算所有能达到的值跟freq，如果用list有大量重复的计算
        然后为了省空间，我们可以用滚动数组去存，而不是开一个map<idx,map<val,freq>>这样的数组，因为当前状态只取决于先前那一个状态
        key: val, val: freq
        */
        public int findTargetSumWays(int[] nums, int S) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int n = nums.length;
//            map.put(nums[0], 1);
            //for 0 and not 0
//            map.put(-nums[0], map.getOrDefault(-nums[0], 0) + 1);
            map.put(0, 1);
            for(int i = 0; i < n; i++){
                HashMap<Integer, Integer> nextmap = new HashMap<>();
                for(int key : map.keySet()){
                    int v1 = key + nums[i];
                    int v2 = key - nums[i];
                    int freq = map.get(key);
                    nextmap.put(v1, nextmap.getOrDefault(v1, 0) + freq);
                    nextmap.put(v2, nextmap.getOrDefault(v2, 0) + freq);
                }
                map.clear();
                map = nextmap;
            }
            return map.getOrDefault(S, 0);
        }
    }


}
