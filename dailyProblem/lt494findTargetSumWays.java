package dailyProblem;

import java.util.HashMap;

public class lt494findTargetSumWays {
    class Solution {
        /*
        当前第i个num来说，我根据前面的sum选择或+或-能产生的结果都有多少种
        dp[0]: 1, -1
        dp[1]: 2, -2, 0,
        */
        public int findTargetSumWays(int[] nums, int S) {
            int res = 0;
            HashMap<Integer, Integer> cur = new HashMap<>();
            if(nums[0] == 0){
                cur.put(nums[0], 2);
            }else{
                cur.put(nums[0], 1);
                cur.put(nums[0] * -1, 1);
            }
            for(int i = 1; i < nums.length; i++){
                HashMap<Integer, Integer> next = new HashMap<>();
                for(int key : cur.keySet()){
                    int add = key + nums[i];
                    int sub = key - nums[i];
                    int freq = cur.get(key);
                    next.put(add, cur.get(key) + next.getOrDefault(add, 0));
                    next.put(sub, cur.get(key) + next.getOrDefault(sub, 0));
                }
                cur.clear();
                cur.putAll(next);
            }
            return cur.getOrDefault(S, 0);
        }
    }
}
