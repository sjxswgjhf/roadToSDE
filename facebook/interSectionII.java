package facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class interSectionII {

    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            HashMap<Integer, Integer> map = new HashMap<>();
            List<Integer> list = new ArrayList<>();
            for(int num : nums1){
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            for(int num : nums2){
                if(map.containsKey(num) && map.get(num) > 0){
                    list.add(num);
                    map.put(num, map.get(num) - 1);
                }
            }
            int[] res = new int[list.size()];
            for(int i = 0; i < list.size(); i++){
                res[i] = list.get(i);
            }
            return res;
        }
    }
}
