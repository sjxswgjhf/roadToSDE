package Bloomberg;

import java.util.HashMap;

public class twoSum {
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            //key: num, value: idx
            //2,7,11,15 9
            HashMap<Integer, Integer> map = new HashMap<>();
            int[] res = new int[2];
            for(int i = 0; i < nums.length; i++){
                if(map.containsKey(target - nums[i])){
                    res[0] = map.get(target - nums[i]);
                    res[1] = i;
                    return res;
                }
                map.put(nums[i], i);
            }
            return res;
        }
    }
}
