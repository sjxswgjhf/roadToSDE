package weeklyContest;

import java.util.Arrays;
import java.util.HashMap;

public class lt1647wk214 {

    class Solution {
        public int minDeletions(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            for(char c : s.toCharArray()){
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            int[] counts = new int[map.size()];
            int idx = 0;
            for(int i : map.values()){
                counts[idx++] = i;
            }
            Arrays.sort(counts);
            int res = 0;
            for(int i = counts.length - 2; i >= 0; i--){
                if(counts[i] >= counts[i + 1]){
                    int tmp =  counts[i + 1]  == 0 ? 0 : counts[i + 1] - 1;
                    res += counts[i] - tmp;
                    counts[i] =  tmp;

                }

            }
            return res;
        }
    }
}
