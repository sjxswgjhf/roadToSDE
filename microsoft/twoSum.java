package microsoft;

import java.util.HashMap;

public class twoSum {

    private int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++){
            int cur = nums[i];
            int left = target - cur;
            if(map.containsKey(left)){
                res[0] = map.get(left);
                res[1] = i;
                return res;
            }else{
                map.put(cur, i);
            }
        }
        return res;
    }

}
