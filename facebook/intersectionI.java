package facebook;

import java.util.HashSet;

public class intersectionI {

    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            HashSet<Integer> set = new HashSet<>();
            for(int num : nums1){
                set.add(num);
            }
            HashSet<Integer> list = new HashSet<>();
            for(int num : nums2){
                if(set.contains(num)){
                    list.add(num);
                }
            }
            int[] res = new int[list.size()];
            int idx = 0;
            for(int num : list){
                res[idx++] = num;
            }
            return res;
        }
    }
}
