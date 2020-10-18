package IBM;

import java.util.HashMap;

public class partitionArray {

    public boolean partitionArray(int[] nums, int k){
        if(nums.length % k != 0){
            return false;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
            max = Math.max(max, map.get(num));
        }
        return max <= (nums.length / k);
    }
}
