package facebook;

import java.util.HashMap;

public class lengthOfLongestSubstringKDistinct {
    class Solution {
        public int lengthOfLongestSubstringKDistinct(String s, int k) {
            HashMap<Character, Integer> counts = new HashMap<>();
            int formed = 0;
            int l = 0;
            int res = 0;
            for(int r = 0; r < s.length(); r++){
                char c = s. charAt(r);
                if(counts.containsKey(c)){
                    counts.put(c, counts.get(c) + 1);
                }else{
                    counts.put(c, 1);
                }
                if(counts.size() <= k)
                    res = Math.max(res, r - l + 1);
                while(l < r && counts.size() == k + 1){
                    char tmp = s.charAt(l);
                    counts.put(tmp, counts.get(tmp) - 1);
                    if(counts.get(tmp) == 0){
                        counts.remove(tmp);
                    }
                    l++;
                }
            }
            return res;
        }
    }
}
