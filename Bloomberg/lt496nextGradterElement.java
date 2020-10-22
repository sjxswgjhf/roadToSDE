package Bloomberg;

import java.util.HashMap;

public class lt496nextGradterElement {

    class Solution {
        /*
        Naive: loop in second array
        */
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int[] res = new int[nums1.length];

            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < nums2.length; i++){
                map.put(nums2[i], i);
            }

            for(int i = 0 ; i < nums1.length; i++){
                int candidate = -1;
                int idx = map.get(nums1[i]);
                for(int j = idx; j < nums2.length; j++){
                    if(nums1[i] < nums2[j]){
                        candidate = nums2[j];
                        break;
                    }
                }
                res[i] = candidate;
            }
            return res;
        }
    }
}
