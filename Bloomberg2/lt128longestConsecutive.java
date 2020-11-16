package Bloomberg2;

import java.util.HashMap;

public class lt128longestConsecutive {

    class Solution {

        /*
        [100,4,200,1,3,2]

        map: {100, 1},{4, 4},{200,1}, {1, 4}, {3, 2}
        100: l = 0, r= 0, t= 1,
        4: l = 0, r = 0, t = 1,
        200: l= 0, r= 0 , t = 1,
        1: l = 0, r= 0; t = 1
        3: l = 0, r = 1, t = 2
        2: l = 1, r = 2, t = 4
        res = 4
        */
        public int longestConsecutive(int[] nums) {
            if(nums == null || nums.length == 0){
                return 0;
            }
            //key: value    val:len
            HashMap<Integer, Integer> map = new HashMap<>();
            int res = 0;
            for(int num : nums){
                if(!map.containsKey(num)){
                    int left = map.getOrDefault(num - 1, 0);
                    int right = map.getOrDefault(num + 1, 0);
                    int total = left + right + 1;
                    //update left boundary
                    if(left != 0){
                        map.put(num - left, total);
                    }
                    //update right boundary
                    if(right != 0){
                        map.put(num + right, total);
                    }
                    map.put(num, total);
                    res = Math.max(res, total);
                }
            }
            return res;
        }
    }
}
