package binarysearch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class bs108removeDuplicateNumbers {

    class Solution {

        public int[] solve(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            HashSet<Integer> dup = new HashSet<>();
            for(int i = 0; i < nums.length; i++){
                int num = nums[i];
                if(map.containsKey(num)){
                    map.remove(num);
                    dup.add(num);
                }
                else if(!map.containsKey(num) && dup.contains(num)){
                    continue;
                }
                else if(!map.containsKey(num) && !dup.contains(num)){
                    map.put(num, i);
                }
            }
            int[] tmp = new int[map.size()];
            int idx = 0;
            for(int key : map.keySet()){
                tmp[idx] = map.get(key);
                idx++;
            }
            Arrays.sort(tmp);
            int[] res = new int[map.size()];
            for(int i = 0; i < res.length; i++){
                res[i] = nums[tmp[i]];
            }
            return res;
        }
    }
}
